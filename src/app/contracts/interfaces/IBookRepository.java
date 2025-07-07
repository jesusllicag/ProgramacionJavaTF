package app.contracts.interfaces;

public interface IBookRepository {
    String[] getAll();
    void toSave(String... args);
    String findByTitle(String title);
    String findByIsbn(String isbn);
}
