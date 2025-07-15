package app.bootstrap.providers;

import app.controllers.BookController;
import app.controllers.LoanController;
import app.controllers.ReportController;
import app.controllers.UserController;
import app.repositories.BookRepository;
import app.repositories.LoanRepository;
import app.repositories.UserRepository;
import database.Books;
import database.Loans;
import database.Stocks;
import database.Users;


public class UseCaseProvider {

    public BookController book(Books books, Stocks stocks, Loans loans) {
        return new BookController(
                new BookRepository(books, stocks, loans)
        );
    }

    public UserController user(Users users) {
        return new UserController(
                new UserRepository(users)
        );
    }

    public LoanController loan(Loans loans, Users users, Books books, Stocks stocks) {
        return new LoanController(
                new LoanRepository(loans, users, books),
                new UserRepository(users),
                new BookRepository(books, stocks, loans)
        );
    }

    public ReportController report(Loans loans, Users users, Books books, Stocks stocks) {
        return new ReportController(
                new LoanRepository(loans, users, books),
                new UserRepository(users),
                new BookRepository(books, stocks, loans)
        );
    }
 }
