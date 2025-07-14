package app.contracts.models;

import app.contracts.classes.Model;

public class Stock extends Model {
    protected String bookId;
    protected String quantity;
    
    public void init(int id, String ...data) {
        this.id = id;
        this.bookId = data[0];
        this.quantity = data[1];
    }

    public String getBookId() {
        return bookId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String toBookRelationString() {
        return "Cantidad: " + this.quantity;
    }
}
