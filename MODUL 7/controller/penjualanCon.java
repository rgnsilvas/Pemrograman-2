package controller;

import java.sql.Connection;
import java.sql.Date;
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
import model.DBconnect;
import model.Penjualan;

public class penjualanCon {
    @FXML
    private TextField jumlahField, totalHargaField, tanggalField, pelangganIdField, bukuIdField;
    @FXML
    private TableView<Penjualan> penjualanTable;
    @FXML
    private TableColumn<Penjualan, Integer> jumlahColumn, pelangganIdColumn, bukuIdColumn;
    @FXML
    private TableColumn<Penjualan, Double> totalHargaColumn;
    @FXML
    private TableColumn<Penjualan, String> tanggalColumn;
    @FXML
    private Button addButton, editButton, deleteButton, toPelangganButton, toBukuButton;

    private ObservableList<Penjualan> penjualanList;

    @FXML
    private void initialize() {
        penjualanList = FXCollections.observableArrayList();
        loadData();

        jumlahColumn.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        totalHargaColumn.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        pelangganIdColumn.setCellValueFactory(new PropertyValueFactory<>("pelangganId"));
        bukuIdColumn.setCellValueFactory(new PropertyValueFactory<>("bukuId"));
        
        penjualanTable.setItems(penjualanList);

        addButton.setOnAction(event -> addPenjualan());
        editButton.setOnAction(event -> editPenjualan());
        deleteButton.setOnAction(event -> deletePenjualan());
        toBukuButton.setOnAction(event -> navigateTo("/view/Buku.fxml", "Data Buku"));
        toPelangganButton.setOnAction(event -> navigateTo("/view/Pelanggan.fxml", "Data Pelanggan"));
    }

    private void loadData() {
        penjualanList.clear();
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Penjualan")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                penjualanList.add(new Penjualan(
                        rs.getInt("penjualan_id"),
                        rs.getInt("jumlah"),
                        rs.getDouble("total_harga"),
                        rs.getDate("tanggal"),
                        rs.getInt("pelanggan_id"),
                        rs.getInt("buku_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPenjualan() {
        int jumlah = Integer.parseInt(jumlahField.getText());
        double totalHarga = Double.parseDouble(totalHargaField.getText());
        Date tanggal = Date.valueOf(tanggalField.getText());
        int pelangganId = Integer.parseInt(pelangganIdField.getText());
        int bukuId = Integer.parseInt(bukuIdField.getText());

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setInt(1, jumlah);
            stmt.setDouble(2, totalHarga);
            stmt.setDate(3, tanggal);
            stmt.setInt(4, pelangganId);
            stmt.setInt(5, bukuId);
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editPenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No selection", "Please select a sale to edit.");
            return;
        }

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE Penjualan SET jumlah = ?, total_harga = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?")) {
            stmt.setInt(1, Integer.parseInt(jumlahField.getText()));
            stmt.setDouble(2, Double.parseDouble(totalHargaField.getText()));
            stmt.setDate(3, Date.valueOf(tanggalField.getText()));
            stmt.setInt(4, Integer.parseInt(pelangganIdField.getText()));
            stmt.setInt(5, Integer.parseInt(bukuIdField.getText()));
            stmt.setInt(6, selected.getPenjualanId());
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deletePenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No selection", "Please select a sale to delete.");
            return;
        }

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM Penjualan WHERE penjualan_id = ?")) {
            stmt.setInt(1, selected.getPenjualanId());
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
            Stage stage = (Stage) toBukuButton.getScene().getWindow(); // Mengambil stage dari tombol yang ditekan
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
