package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class loginCon {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label loginMessage;

    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("sisil") && password.equals("1234")) {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Scene bookScene = new Scene(FXMLLoader.load(getClass().getResource("/view/book.fxml")));
            stage.setScene(bookScene);
        } else {
            loginMessage.setText("Login gagal! Periksa username dan password.");
        }
    }
}
