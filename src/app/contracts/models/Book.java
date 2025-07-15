package app.contracts.models;

import app.contracts.classes.Model;

import java.util.List;

public class Book extends Model {
    protected String isbn;
    protected String title;
    protected String author;
    protected String year;
    protected Stock stock;
    protected List<Loan> loans;

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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        this.loans.remove(loan);
    }

    public int getLoansQuantity() {
        return this.loans.size();
    }

    public int getAvailableBooksQuantity() {
        int loansQuantity = this.loans.stream().map(Loan::getQuantity).reduce(0, Integer::sum);
        return Integer.parseInt(this.getStock().getQuantity()) - loansQuantity;
    }

    @Override
    public String toString() {
        return  "ID: " + this.id + " | " +
                "ISBN: " + this.isbn + " | " +
                "Titulo: " + this.title + " | " +
                "Autor: " + this.author + " | " +
                "Año de Publicación: " + this.year;
    }

    public String toStringforUserLoanedRelation() {
        return "Libro: " + this.title;
    }

    public String toStringWithStock() {
        return this.toString() + " | " + this.stock.toBookRelationString();
    }

    public String toStringLoan() {
        return this.toString() + " | Cantidad: " + this.getAvailableBooksQuantity();
    }
}
