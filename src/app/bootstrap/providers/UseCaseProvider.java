package app.bootstrap.providers;

import app.controllers.BookController;
import app.controllers.UserController;
import app.repositories.BookRepository;
import app.repositories.UserRepository;
import database.Books;
import database.Stocks;
import database.Users;


public class UseCaseProvider {

    public BookController book(Books books, Stocks stocks) {
        return new BookController(
                new BookRepository(books, stocks)
        );
    }

    public UserController user(Users users) {
        return new UserController(
                new UserRepository(users)
        );
    }
 }
