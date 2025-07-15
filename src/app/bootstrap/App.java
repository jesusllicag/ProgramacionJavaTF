package app.bootstrap;

import app.bootstrap.providers.UseCaseProvider;
import app.bootstrap.providers.LabelProvider;
import app.contracts.interfaces.AppModules;
import app.contracts.interfaces.IController;
import app.utils.AppUtils;
import app.views.MenuOptionsView;
import database.Books;
import database.Loans;
import database.Stocks;
import database.Users;

import java.lang.reflect.Method;
import java.util.Arrays;

public class App implements AppModules {

    public Books books = new Books();
    public Stocks stocks = new Stocks();
    public Users users = new Users();
    public Loans loans = new Loans();

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

    // Imprime en pantalla el menu de opciones para seleccionar el caso de uso
    private String renderMenuInterfaces() {
        MenuOptionsView viewMenu = new MenuOptionsView();
        String controller;
        do {
            viewMenu.setMenuLabel(this.labelProvider.getMainMenuLabel());
            viewMenu.run();
            if(viewMenu.isExit()) {
                viewMenu.imprimirPantalla("\n\nSaliendo del programa.");
                return AppModules.EXIT + "::" + AppModules.EXIT;
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
                case AppModules.BOOK -> this.useCaseProvider.book(books, stocks, loans);
                case AppModules.USER -> this.useCaseProvider.user(users);
                case AppModules.LOAN -> this.useCaseProvider.loan(loans, users, books, stocks);
                case AppModules.REPORT -> this.useCaseProvider.report(loans, users, books, stocks);
                default -> throw new IllegalStateException("El modulo: '" + module + "' no esta configurado.");
            };
            Method method = controller.getClass().getMethod(methodName);
            method.invoke(controller);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("Método no encontrado: " + module + "::" + methodName);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private void closeApplication() {
       System.out.printf(AppUtils.getASCIIUtpLogo());
       System.out.println("Desarrollado por:");
       System.out.println(AppUtils.getOwnerSignature());
    }

}
