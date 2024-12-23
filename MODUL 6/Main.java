package soal1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PRAKTIKUM 6");

        TableView<Mahasiswa> tabel = new TableView<>();
        
        TableColumn<Mahasiswa, Integer> kolom1 = new TableColumn<>("ID");
        kolom1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Mahasiswa, String> kolom2 = new TableColumn<>("NIM");
        kolom2.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> kolom3 = new TableColumn<>("Nama");
        kolom3.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tabel.getColumns().add(kolom1);
        tabel.getColumns().add(kolom2);
        tabel.getColumns().add(kolom3);

        tabel.getItems().add(new Mahasiswa(1, "2310817220011", "Sisil"));
        tabel.getItems().add(new Mahasiswa(2, "2310817220012", "Anne"));
        tabel.getItems().add(new Mahasiswa(3, "2310817220013", "Jill"));
        tabel.getItems().add(new Mahasiswa(4, "2310817220014", "Claire"));
        tabel.getItems().add(new Mahasiswa(5, "2310817220015", "Leon"));
        tabel.getItems().add(new Mahasiswa(6, "2310817220016", "Cassandra"));
        tabel.getItems().add(new Mahasiswa(7, "2310817220017", "Carlos"));
        tabel.getItems().add(new Mahasiswa(8, "2310817220018", "Ashley"));
        tabel.getItems().add(new Mahasiswa(9, "2310817220019", "Ethan"));
        tabel.getItems().add(new Mahasiswa(10, "2310817220024", "Rose"));


        VBox box = new VBox(tabel);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
