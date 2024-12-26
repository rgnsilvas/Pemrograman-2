package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Buku;
import model.DBconnect;

public class bukuCon {
    @FXML
    private TextField judulField, penulisField, hargaField, stokField;
    @FXML
    private TableView<Buku> bukuTable;
    @FXML
    private TableColumn<Buku, String> judulColumn, penulisColumn;
    @FXML
    private TableColumn<Buku, Double> hargaColumn;
    @FXML
    private TableColumn<Buku, Integer> stokColumn;
    @FXML
    private Button addButton, editButton, deleteButton, toPelangganButton, toPenjualanButton;

    private ObservableList<Buku> bukuList;

    @FXML
    private void initialize() {
        bukuList = FXCollections.observableArrayList();
        loadData();

        judulColumn.setCellValueFactory(new PropertyValueFactory<>("judul"));
        penulisColumn.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        hargaColumn.setCellValueFactory(new PropertyValueFactory<>("harga"));
        stokColumn.setCellValueFactory(new PropertyValueFactory<>("stok"));
        
        bukuTable.setItems(bukuList);

        addButton.setOnAction(event -> addBuku());
        editButton.setOnAction(event -> editBuku());
        deleteButton.setOnAction(event -> deleteBuku());
        toPelangganButton.setOnAction(event -> navigateTo("/view/Pelanggan.fxml", "Data Pelanggan"));
        toPenjualanButton.setOnAction(event -> navigateTo("/view/Penjualan.fxml", "Data Penjualan"));
    }

    private void loadData() {
        bukuList.clear();
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Buku")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bukuList.add(new Buku(
                        rs.getInt("buku_id"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addBuku() {
        String judul = judulField.getText();
        String penulis = penulisField.getText();
        double harga = Double.parseDouble(hargaField.getText());
        int stok = Integer.parseInt(stokField.getText());

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setDouble(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No selection", "Please select a book to edit.");
            return;
        }

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE Buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?")) {
            stmt.setString(1, judulField.getText());
            stmt.setString(2, penulisField.getText());
            stmt.setDouble(3, Double.parseDouble(hargaField.getText()));
            stmt.setInt(4, Integer.parseInt(stokField.getText()));
            stmt.setInt(5, selected.getBukuId());
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No selection", "Please select a book to delete.");
            return;
        }

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM Buku WHERE buku_id = ?")) {
            stmt.setInt(1, selected.getBukuId());
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void navigateTo(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) toPelangganButton.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
