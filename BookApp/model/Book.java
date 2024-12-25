package model;

import javafx.beans.property.*;

public class Book {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleStringProperty synopsis;
    private final SimpleStringProperty genre;
    private final SimpleIntegerProperty publishedYear;
    private final SimpleDoubleProperty price;

    public Book(int id, String title, String author, String synopsis, String genre, int publishedYear, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.synopsis = new SimpleStringProperty(synopsis);
        this.genre = new SimpleStringProperty(genre);
        this.publishedYear = new SimpleIntegerProperty(publishedYear);
        this.price = new SimpleDoubleProperty(price);
    }

    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getTitle() { return title.get(); }
    public StringProperty titleProperty() { return title; }

    public String getAuthor() { return author.get(); }
    public StringProperty authorProperty() { return author; }

    public String getSynopsis() { return synopsis.get(); }
    public StringProperty synopsisProperty() { return synopsis; }

    public String getGenre() { return genre.get(); }
    public StringProperty genreProperty() { return genre; }

    public int getPublishedYear() { return publishedYear.get(); }
    public IntegerProperty publishedYearProperty() { return publishedYear; }

    public double getPrice() { return price.get(); }
    public DoubleProperty priceProperty() { return price; }
}
