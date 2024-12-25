package MainApp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml")));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selamat Datang sisil!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
