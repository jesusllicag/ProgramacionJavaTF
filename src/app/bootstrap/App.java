package app.bootstrap;

import app.bootstrap.providers.LabelProvider;
import app.config.Project;
import app.contracts.interfaces.IController;
import app.controllers.BookController;
import app.controllers.UserController;
import app.repositories.BookRepository;
import app.views.MenuOpciones;
import database.Books;
import database.Users;

import java.lang.reflect.Method;

public class App {

    private final LabelProvider labelProvider = new LabelProvider();
    public Books books = new Books();
    public Users users = new Users();

    public void run() {
        boolean loop = true;
        while (loop) {
            String selection = this.renderMenuInterfaces();
            if (selection.equals("exit::exit")) {
                loop = false;
                this.closeApplication();
            } else {
                String[] instruction = selection.split("::");
                this.executeUseCase(instruction);
            }
        }
    }

    private String renderMenuInterfaces() {
        MenuOpciones viewMenu = new MenuOpciones();
        String controller;
        do {
            viewMenu.setMenuLabel(this.labelProvider.getMainMenuLabel());
            viewMenu.run();
            if(viewMenu.isExit()) {
                viewMenu.imprimirPantalla("Saliendo del programa.");
                return "exit::exit";
            }
            controller = viewMenu.getOptionIndex();

            viewMenu.setMenuLabel(this.labelProvider.getSubMenuLabel(controller));
            viewMenu.run();
        } while(viewMenu.isExit());
        String method = viewMenu.getOptionIndex();
        return controller + "::" + method;
    }

    private void executeUseCase(String[] args) {
        String module = args[0];
        String methodName = args[1];
        try {
            IController controller = switch (module) {
                case "book" -> new BookController(new BookRepository(books));
                case "user" -> new UserController(users);
                default -> throw new IllegalStateException("Unexpected value: " + module);
            };
            Method method = controller.getClass().getMethod(methodName);
            method.invoke(controller);
        } catch (NoSuchMethodException e) {
            System.out.println("Método no encontrado: " + module + "::" + methodName);
        } catch (Exception e) {
            System.out.println("Error ejecutando método: " + e.getMessage());
        }
    }

    private void closeApplication() {
       System.out.printf(Project.getASCIIUtpLogo());
       System.out.println("Desarrollado por:");
       System.out.println(Project.getOwner());
    }

}
