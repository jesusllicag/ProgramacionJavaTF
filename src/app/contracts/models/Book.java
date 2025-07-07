package app.contracts.models;

import app.contracts.classes.Model;

public class Book extends Model {
    protected String isbn;
    protected String title;
    protected String author;
    protected String year;

    public void init(int id, String ...data) {
        this.id = id;
        this.isbn = data[0];
        this.title = data[1];
        this.author = data[2];
        this.year = data[3];
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return this.id + " | " + this.isbn + " | " + this.title + " | " + this.author + " | " + this.year;
    }
}
