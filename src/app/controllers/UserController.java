package app.controllers;

import app.config.DatabaseTable;
import app.contracts.interfaces.IController;
import app.contracts.models.User;

public class UserController implements IController {

    protected DatabaseTable<User> db;

    public UserController(DatabaseTable<User> databaseTable) {
        this.db = databaseTable;
    }

    public void index() {
        System.out.println("List of Users");
    }

    public void store() {
        System.out.println("Create User");
    }

    public void show() {
        System.out.println("Search of Users");
    }

    public void update() {
        System.out.println("Edit User");
    }

    public void destroy() {
        System.out.println("Delete User");
    }
}
