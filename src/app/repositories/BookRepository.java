package app.repositories;

import app.config.DatabaseTable;
import app.contracts.classes.Repository;
import app.contracts.interfaces.IRepository;
import app.contracts.models.Book;

public class BookRepository extends Repository<Book> implements IRepository {

    public BookRepository(DatabaseTable<Book> databaseTable) {
      super(databaseTable);
    }

    public void toSave(String... args) {
        int id = this.database.createId();
        Book book = new Book();
        book.init(id, args);
        this.save(book);
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
        return switch (filterCase[0]) {
            case "1" -> this.getById(filterCase[1]);
            case "2" -> this.getByIsbn(filterCase[1]);
            case "3" -> this.getByTitle(filterCase[1]);
            default -> throw new IllegalStateException("Saliendo sin realizar acción");
        };
    }

}
