package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Book;
import model.DataConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class databukuCon {
	@FXML private Label welcomeLabel;
    @FXML private TableView<Book> bookTable;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> synopsisColumn; 

    private ObservableList<Book> books = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        
        titleColumn.setCellValueFactory(data -> data.getValue().titleProperty());
        authorColumn.setCellValueFactory(data -> data.getValue().authorProperty());
        synopsisColumn.setCellValueFactory(data -> data.getValue().synopsisProperty());

        loadBooks();
        bookTable.setItems(books);
        
        bookTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { 
                Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
                if (selectedBook != null) {
                    showBookDetails(selectedBook); 
                }
            }
        });
    }

    private void loadBooks() {
        try (Connection conn = DataConnect.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                books.add(new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("synopsis"),
                    rs.getString("genre"),
                    rs.getInt("published_year"),
                    rs.getDouble("price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void showBookDetails(Book book) {
        Alert detailAlert = new Alert(Alert.AlertType.INFORMATION);
        detailAlert.setTitle("Detail Buku");
        detailAlert.setHeaderText(book.getTitle() + " oleh " + book.getAuthor());
        detailAlert.setContentText(
            "Judul: " + book.getTitle() + "\n" +
            "Pengarang: " + book.getAuthor() + "\n" +
            "Sinopsis: " + book.getSynopsis() + "\n" +
            "Genre: " + book.getGenre() + "\n" +
            "Tahun Terbit: " + book.getPublishedYear() + "\n" +
            "Harga: Rp" + book.getPrice()
        );
        detailAlert.showAndWait();
    }

    @FXML
    private void handleExit() {
        Stage stage = (Stage) bookTable.getScene().getWindow();
        stage.close();
    }
}
