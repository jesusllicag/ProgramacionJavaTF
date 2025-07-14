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

public class LoanController extends Controller implements IController {

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
        String[] loanData = new String[3];
        this.view.println("Registrar nuevo préstamo");
        this.view.println("Selección de Usuario:");
        List<User> userList = this.userRepository.getAll();
        this.userView.runViewList(userList);
        loanData[0] = this.view.readInput("Ingrese el ID del usuario que realiza el préstamo: ");
        this.view.println("\nSelección de Libro:");
        List<Book> listBooks = this.bookRepository.getAllWithStock();
        this.bookView.runViewList(listBooks);
        loanData[1] = this.view.readInput("Ingrese el ID del libro que desea prestarse: ");
        Book book = this.bookRepository.getFullById(loanData[1]);
        loanData[2] = this.view.runViewStore(book);
        this.repository.toSave(loanData);
        this.view.println("Préstamo guardado");
    }

    public void update() throws ClassNotFoundException {
        this.view.println("Devolución de Prestamos");
        List<Loan> list = this.repository.getActiveList();

        if (list.isEmpty()) {
            this.view.println("No hay préstamos registrados aún.\n");
            return;
        }

        String code = this.view.runViewUpdateSelector(list);
        Loan loan = this.repository.getByCode(code);
        loan.setRtnDate();
        this.view.println("Devolución exitosa");
    }
}
