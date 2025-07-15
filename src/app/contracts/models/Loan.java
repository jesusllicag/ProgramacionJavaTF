package app.contracts.models;

import app.contracts.classes.Model;
import app.utils.IdUtils;
import java.time.LocalDateTime;

public class Loan extends Model {

    private String code;
    private User user;
    private Book book;
    private int quantity;
    private String loanDate;
    private String rtnDate;

    @Override
    public void init(int id, String... data) { }

    public void init(int id, User user, Book book, int quantity) {
        this.id = id;
        this.code = IdUtils.randomCode();
        this.user = user;
        this.book = book;
        this.quantity = quantity;
        this.loanDate = LocalDateTime.now().toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCode() {
        return code;
    }

    public String getRtnDate() {
        return this.rtnDate;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setRtnDate() {
        this.rtnDate = LocalDateTime.now().toString();
    }

    public String activeLoantoString() {
        return  "ID: " + this.id + " | " +
                "Código: " + this.code + " | " +
                "Usuario: " + this.user.getDni() + " - " + this.user.getName() + " | " +
                "Libro: " + this.book.getTitle() + " | " +
                "Cantidad: " + this.quantity + " | " +
                "Fecha préstamo: " + this.loanDate;
    }

    public String activeLoanBooktoString() {
        return  "Código: " + this.code + " | " +
                "Usuario: " + this.user.getDni() + " - " + this.user.getName() + " | " +
                "Libro: " + this.book.getTitle() + " | " +
                "Cantidad: " + this.quantity + " | " +
                "Fecha préstamo: " + this.loanDate;
    }

    public String toStringUserLoaned() {
        return  this.getUser().toStringforLoanedRelation() + " | " +
                this.getBook().toStringforUserLoanedRelation() + " | " +
                "Cantidad: " + this.quantity + " | " +
                "Fecha préstamo: " + this.loanDate;
    }

    @Override
    public String toString() {
        return this.activeLoantoString() + " | " + "Fecha devolución: " + this.rtnDate;
    }

}
