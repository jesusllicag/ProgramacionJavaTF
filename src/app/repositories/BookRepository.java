package app.repositories;

import app.config.DatabaseTable;
import app.contracts.classes.Model;
import app.contracts.classes.Repository;
import app.contracts.interfaces.IRepository;
import app.contracts.models.Book;
import app.contracts.models.Stock;
import database.Stocks;

import java.util.List;

public class BookRepository extends Repository<Book> implements IRepository {

    @SafeVarargs
    public BookRepository(
            DatabaseTable<Book> databaseTable,
            DatabaseTable<? extends Model> ...relations
    ) {
      super(databaseTable, relations);
    }

    protected Stocks stock() {
        return (Stocks) this.relations[0];
    }

    public Book[] getAllWithStock() {
        List<Book> books = this.database.getRecord();
        List<Stock> stocks = this.stock().getRecord();
        Book[] arr = new Book[books.size()];

        for (int i = 0; i < books.size(); i++) {
            Stock stock = stocks.get(i);
            Book book = books.get(i);
            book.setStock(stock);
            arr[i] = book;
        }

        return arr;
    }

    public void toSave(String... args) {
        int id = this.database.createId();
        Book book = new Book();
        book.init(id, args[0], args[1], args[2], args[3]);
        this.save(book);

        int stockId = this.stock().createId();
        Stock stock = new Stock();
        stock.init(stockId, book.getId(), args[4]);
        this.stock().insert(stock);
    }

    public Book getByTitle(String title) throws ClassNotFoundException {
        for (Book book : this.database.getRecord()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new ClassNotFoundException(IRepository.MSG_ITEM_NOT_FOUND);
    }

    public Book getByIsbn(String isbn) throws ClassNotFoundException {
        for (Book book : this.database.getRecord()) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        throw new ClassNotFoundException(IRepository.MSG_ITEM_NOT_FOUND);
    }

    public Book getSelectedFilter(String[] filterCase) throws IllegalStateException, ClassNotFoundException {
        Book book = switch (filterCase[0]) {
            case "1" -> this.getById(filterCase[1]);
            case "2" -> this.getByIsbn(filterCase[1]);
            case "3" -> this.getByTitle(filterCase[1]);
            default -> throw new IllegalStateException("Saliendo sin realizar acción");
        };
        Stock stock = this.stock().getStockByBookId(book.getId());
        book.setStock(stock);
        return book;
    }

    public boolean toDelete(Book book) throws ClassNotFoundException {
        List<Book> books = this.database.getRecord();
        Stock stock;
        try {
            stock = this.stock().getStockByBookId(book.getId());
        } catch (ClassCastException e) {
            return false;
        }
        books.removeIf(item -> item.getId().equals(book.getId()));
        this.stock().getRecord().removeIf(item -> item.getId().equals(stock.getId()));
        return true;
    }
}
