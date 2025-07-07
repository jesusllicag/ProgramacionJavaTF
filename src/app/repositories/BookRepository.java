package app.repositories;

import app.config.DatabaseTable;
import app.contracts.classes.Repository;
import app.contracts.interfaces.IBookRepository;
import app.contracts.models.Book;

public class BookRepository extends Repository<Book> implements IBookRepository {

    public BookRepository(DatabaseTable<Book> databaseTable) {
      super(databaseTable);
    }

    public void toSave(String... args) {
        int id = this.database.createId();
        Book book = new Book();
        book.init(id, args);
        this.save(book);
    }

    @Override
    public String findByTitle(String title) {
        for (Book book : this.database.getRecord()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.toString();
            }
        }
        return "No se pudo encontrar el registro";
    }

    @Override
    public String findByIsbn(String isbn) {
        for (Book book : this.database.getRecord()) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book.toString();
            }
        }
        return "No se pudo encontrar el registro";
    }

}
