package app.controllers;

import app.contracts.classes.Controller;
import app.contracts.interfaces.IController;
import app.contracts.models.Book;
import app.repositories.BookRepository;
import app.views.BookView;

public class BookController extends Controller<Book> implements IController {

    protected BookRepository repository;
    protected BookView view = new BookView();

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    public void index() {
        this.view.println("Lista de Libros");
        Book[] list = this.repository.getAllWithStock();
        for (Book book : list) {
            this.view.println(book.toStringWithStock());
        }
    }

    public void store() {
        this.view.println("Registrar nuevo Libro");
        String[] book = this.view.runViewStore();
        this.repository.toSave(book);
        this.view.println("Libro Creado");
    }

    public void show() {
        this.view.println("Buscar Libro");
        String[] filter = this.view.runViewSearch();
        String label = "";
        try {
            Book book = this.repository.getSelectedFilter(filter);
            label = book.toStringWithStock();
        } catch (ClassNotFoundException | IllegalStateException e) {
            label = e.getMessage();
        } finally {
            this.view.println(label);
        }
    }

    public void update() {
        this.view.println("Actualizar Libro");
        String[] filter = this.view.runViewSearch();
        Book book;
        try {
            book = this.repository.getSelectedFilter(filter);
        } catch (ClassNotFoundException | IllegalStateException e) {
            this.view.println(e.getMessage());
            return;
        }

        Book updatedBook = this.view.runViewUpdate(book);
        this.repository.update(updatedBook);
        this.view.println("Libro Actualizado");
    }

    public void destroy() throws ClassNotFoundException {
        this.view.println("Eliminar Libro");
        String[] filter = this.view.runViewSearch();
        Book book;
        try {
            book = this.repository.getSelectedFilter(filter);
        } catch (ClassNotFoundException | IllegalStateException e) {
            this.view.println(e.getMessage());
            return;
        }
        String confirm = this.view.readInput(
            "Esta seguro que desea eliminar el siguiente libro? [Y/N]\n" + book.toString() + "\n"
        );
        if (confirm.equalsIgnoreCase("Y")) {
            this.repository.toDelete(book);
            this.view.println("Libro Eliminado");
        } else {
            this.view.println("Saliendo sin realizar acción");
        }
    }
}
