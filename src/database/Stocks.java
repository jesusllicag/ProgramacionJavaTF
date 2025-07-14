package database;

import app.contracts.classes.DatabaseTable;
import app.contracts.models.Stock;

import java.util.List;

public class Stocks extends DatabaseTable<Stock> {

    @Override
    protected Stock model() {
        return new Stock();
    }

    @Override
    protected void seed() {
        this.create("1", "3");
        this.create("2", "5");
        this.create("3", "3");
        this.create("4", "2");
        this.create("5", "1");
        this.create("6", "2");
        this.create("7", "3");
        this.create("8", "1");
    }

    public Stock getByBookId(String bookId) throws ClassNotFoundException {
        List<Stock> stocks = this.getRecord();
        for (Stock stock : stocks) {
            if (stock.getBookId().equals(bookId)) {
                return stock;
            }
        }
        throw new ClassNotFoundException(DatabaseTable.MSG_ITEM_NOT_FOUND);
    }
}
