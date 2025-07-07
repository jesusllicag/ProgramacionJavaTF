package app.controllers;

import app.contracts.classes.Controller;
import app.contracts.interfaces.IBookRepository;
import app.contracts.interfaces.IController;
import app.contracts.models.Book;
import app.views.BookView;

public class BookController extends Controller<Book> implements IController {

    protected IBookRepository repository;
    protected BookView view;

    public BookController(IBookRepository repository) {
        this.repository = repository;
        this.view = new BookView();
    }

    public void index() {
        String[] list = this.repository.getAll();
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void store() {
        String[] bookData = this.view.runViewStore();
        this.repository.toSave(bookData);
        this.view.println("Libro Creado");
    }

    public void show() {
        String[] filter = this.view.runViewShow();
        String label = switch (filter[0]) {
            case "1" -> this.repository.findByIsbn(filter[1]);
            case "2" -> this.repository.findByTitle(filter[1]);
            default -> throw new IllegalArgumentException("Tipo Invalido");
        };
        this.view.println(label);
    }

    public void update() {
        System.out.println("Edit Libro");
    }

    public void destroy() {
        System.out.println("Delete Libro");
    }
}
