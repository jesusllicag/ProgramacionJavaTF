package app.controllers;

import app.contracts.classes.Controller;
import app.contracts.interfaces.IController;
import app.contracts.models.Book;
import app.contracts.models.Loan;
import app.contracts.models.User;
import app.repositories.BookRepository;
import app.repositories.LoanRepository;
import app.repositories.UserRepository;
import app.views.BookView;
import app.views.LoanView;
import app.views.UserView;
import java.util.List;

public class LoanController extends Controller<Loan> implements IController {

    protected LoanRepository repository;
    protected UserRepository userRepository;
    protected BookRepository bookRepository;
    protected LoanView view = new LoanView();
    protected BookView bookView = new BookView();
    protected UserView userView = new UserView();

    public LoanController(LoanRepository repository, UserRepository userRepository, BookRepository bookRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void index() {
        this.view.println("Lista de Prestamos");
        List<Loan> list = this.repository.getActiveList();

        if (list.isEmpty()) {
            this.view.println("No hay préstamos registrados aún.\n");
            return;
        }

        this.view.runViewList(list);
    }

    public void store() throws ClassNotFoundException {
        this.view.println("Registrar nuevo préstamo");
        this.view.println("Selección de Usuario:");
        List<User> userList = this.userRepository.getAll();
        this.userView.runViewList(userList);

        String userId = this.view.readInput("Ingrese el ID del usuario que realiza el préstamo: ");
        this.view.println("\nSelección de Libro:");
        List<Book> listBooks = this.bookRepository.getAllWithRelations();
        this.bookView.runViewList(listBooks);
        String bookId = this.view.readInput("Ingrese el ID del libro que desea prestarse: ");
        Book book = this.bookRepository.getFullById(bookId);
        String loanQuantity = this.view.runViewStore(book);
        this.repository.toSave(userId, bookId, loanQuantity);
        this.view.println("Préstamo guardado");
    }

    public void update() throws ClassNotFoundException {
        this.view.println("Devolución de Prestamos");
        List<Loan> list = this.repository.getActiveList();

        if (list.isEmpty()) {
            this.view.println("No hay préstamos registrados aún.\n");
            return;
        }
        Loan loan = null;
        do {
            try {
                String code = this.view.runViewUpdateSelector(list);
                loan = this.repository.getByCode(code);
            } catch (ClassNotFoundException e) {
                this.view.println("El código ingresado es incorrecto.");
            }
        } while (loan == null);
        loan.setRtnDate();
        this.view.println("Devolución exitosa");
    }
}
