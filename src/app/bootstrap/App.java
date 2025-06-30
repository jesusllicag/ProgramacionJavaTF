package app.bootstrap;

import app.config.Project;
import app.views.MenuOpciones;
import java.lang.reflect.Method;

public class App {

    public void run() {
        boolean loop = true;
        while (loop) {
            String selection = this.renderMenuInterfaces();
            if (selection.equals("exit::exit")) {
                loop = false;
                this.closeApplication();
            } else {
                String[] instruction = selection.split("::");
                this.execute(instruction);
            }
        }
    }

    private String renderMenuInterfaces() {
        MenuOpciones viewMenu = new MenuOpciones();
        String controller;
        do {
            viewMenu.setMenuLabel(Provider.getMainMenuLabel());
            viewMenu.run();
            if(viewMenu.isExit()) {
                viewMenu.imprimirPantalla("Saliendo del programa.");
                return "exit::exit";
            }
            controller = viewMenu.getOptionIndex();

            viewMenu.setMenuLabel(Provider.getSubMenuLabel(controller));
            viewMenu.run();
        } while(viewMenu.isExit());
        String method = viewMenu.getOptionIndex();
        return controller + "::" + method;
    }

    private void execute(String[] args) {
        try {
            Class<?> controller = Class.forName("app.controllers." + args[0]);
            Object instancia = controller.getDeclaredConstructor().newInstance();
            Method method = controller.getMethod(args[1]);
            method.invoke(instancia);
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + args[0]);
        } catch (NoSuchMethodException e) {
            System.out.println("Método no encontrado: " + args[0] + "::" +args[1]);
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
