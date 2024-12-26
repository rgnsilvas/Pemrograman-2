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
import model.DBconnect;
import model.Pelanggan;

public class pelangganCon {
    @FXML
    private TextField namaField, emailField, teleponField;
    @FXML
    private TableView<Pelanggan> pelangganTable;
    @FXML
    private TableColumn<Pelanggan, String> namaColumn, emailColumn, teleponColumn;
    @FXML
    private Button addButton, editButton, deleteButton, toBukuButton, toPenjualanButton;

    private ObservableList<Pelanggan> pelangganList;

    @FXML
    private void initialize() {
        pelangganList = FXCollections.observableArrayList();
        loadData();

        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        teleponColumn.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        
        pelangganTable.setItems(pelangganList);

        addButton.setOnAction(event -> addPelanggan());
        editButton.setOnAction(event -> editPelanggan());
        deleteButton.setOnAction(event -> deletePelanggan());
        toBukuButton.setOnAction(event -> navigateTo("/view/Buku.fxml", "Data Buku"));
        toPenjualanButton.setOnAction(event -> navigateTo("/view/Penjualan.fxml", "Data Penjualan"));
    }

    private void loadData() {
        pelangganList.clear();
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Pelanggan")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pelangganList.add(new Pelanggan(
                        rs.getInt("pelanggan_id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("telepon")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPelanggan() {
        String nama = namaField.getText();
        String email = emailField.getText();
        String telepon = teleponField.getText();

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Pelanggan (nama, email, telepon) VALUES (?, ?, ?)")) {
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editPelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No selection", "Please select a pelanggan to edit.");
            return;
        }

        namaField.setText(selected.getNama());
        emailField.setText(selected.getEmail());
        teleponField.setText(selected.getTelepon());

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE Pelanggan SET nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?")) {
            stmt.setString(1, namaField.getText());
            stmt.setString(2, emailField.getText());
            stmt.setString(3, teleponField.getText());
            stmt.setInt(4, selected.getPelangganId());
            stmt.executeUpdate();
            
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void deletePelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("No selection", "Please select a pelanggan to delete.");
            return;
        }

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM Pelanggan WHERE pelanggan_id = ?")) {
            stmt.setInt(1, selected.getPelangganId());
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
            Stage stage = (Stage) toBukuButton.getScene().getWindow();
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
