package app.bootstrap;

import app.bootstrap.providers.UseCaseProvider;
import app.bootstrap.providers.LabelProvider;
import app.contracts.interfaces.IController;
import app.controllers.UserController;
import app.repositories.UserRepository;
import app.views.MenuOpciones;
import database.Books;
import database.Stocks;
import database.Users;

import java.lang.reflect.Method;

public class App {

    public Books books = new Books();
    public Stocks stocks = new Stocks();
    public Users users = new Users();

    private final LabelProvider labelProvider = new LabelProvider();
    private final UseCaseProvider useCaseProvider = new UseCaseProvider();

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
                viewMenu.imprimirPantalla("\n\nSaliendo del programa.");
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
                case "book" -> this.useCaseProvider.book(books, stocks);
                case "user" -> this.useCaseProvider.user(users);
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
       System.out.printf(app.config.App.getASCIIUtpLogo());
       System.out.println("Desarrollado por:");
       System.out.println(app.config.App.getOwnerSignature());
    }

}
