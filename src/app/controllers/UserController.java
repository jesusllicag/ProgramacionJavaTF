package app.controllers;

import app.config.DatabaseTable;
import app.contracts.classes.Controller;
import app.contracts.interfaces.IController;
import app.contracts.models.User;
import app.contracts.models.User;
import app.repositories.UserRepository;
import app.repositories.UserRepository;
import app.views.UserView;
import app.views.UserView;

import java.util.List;

public class UserController extends Controller<User> implements IController {

    protected UserRepository repository;
    protected UserView view = new UserView();

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public void index() {
        this.view.println("Lista de Estudiantes");
        List<User> list = this.repository.getAll();
        for (User user : list) {
            this.view.println(user.toString());
        }
    }

    public void store() {
        this.view.println("Registrar nuevo Usuario");
        String[] user = this.view.runViewStore();
        this.repository.toSave(user);
        this.view.println("Usuario Creado");
    }

    public void show() {
        this.view.println("Buscar Usuario");
        String[] filter = this.view.runViewSearch();
        String label = "";
        try {
            User user = this.repository.getSelectedFilter(filter);
            label = user.toString();
        } catch (ClassNotFoundException | IllegalStateException e) {
            label = e.getMessage();
        } finally {
            this.view.println(label);
        }
    }

    public void update() {
        this.view.println("Actualizar Usuario");
        String[] filter = this.view.runViewSearch();
        User user;
        try {
            user = this.repository.getSelectedFilter(filter);
        } catch (ClassNotFoundException | IllegalStateException e) {
            this.view.println(e.getMessage());
            return;
        }

        User updatedUser = this.view.runViewUpdate(user);
        this.repository.update(updatedUser);
        this.view.println("Usuario Actualizado");
    }

    public void destroy() {
        this.view.println("Eliminar Usuario");
        String[] filter = this.view.runViewSearch();
        User user;
        try {
            user = this.repository.getSelectedFilter(filter);
        } catch (ClassNotFoundException | IllegalStateException e) {
            this.view.println(e.getMessage());
            return;
        }
        String confirm = this.view.readInput(
                "Esta seguro que desea eliminar el siguiente libro? [Y/N]\n" + user.toString() + "\n"
        );
        if (confirm.equalsIgnoreCase("Y")) {
            this.repository.delete(user);
            this.view.println("Usuario Eliminado");
        } else {
            this.view.println("Saliendo sin realizar acción");
        }
    }
}
