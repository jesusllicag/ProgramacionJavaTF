package app.controllers;

import app.contracts.classes.Controller;
import app.contracts.models.Book;
import app.contracts.models.Loan;
import app.repositories.BookRepository;
import app.repositories.LoanRepository;
import app.repositories.UserRepository;
import app.views.ReportView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportController extends Controller {

    protected UserRepository userRepository;
    protected LoanRepository loanRepository;
    protected BookRepository bookRepository;
    protected ReportView reportView = new ReportView();

    public ReportController(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void loanList() {
        this.reportView.println("Lista de Libros Prestados");
        List<Loan> list = this.loanRepository.getAll();

        if (list.isEmpty()) {
            this.reportView.println("No hay préstamos registrados aún.\n");
            return;
        }

        this.reportView.runViewLoanedBookList(list);
    }

    public void availableList() {
        this.reportView.println("Lista de Libros Disponibles");
        List<Book> list = this.bookRepository.getAllAvailable();

        if (list.isEmpty()) {
            this.reportView.println("No hay préstamos registrados aún.\n");
            return;
        }

        this.reportView.runViewBookList(list);
    }

    public void userWithMoreLoans() {
        try {
            this.reportView.println("Lista de 5 Usuarios con más préstamos");
            List<Loan> list = new ArrayList<>(this.loanRepository.getActiveList());
            list.sort(Comparator.comparingInt(Loan::getQuantity).reversed());
            List<Loan> topFive = list.stream().limit(5).collect(Collectors.toList());
            this.reportView.runViewTopLoanedUserList(topFive);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
