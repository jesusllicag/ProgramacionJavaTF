package app.bootstrap;

import app.views.MenuOpciones;

public class App {

    private String selectedOption;

    public void run() {
        while (true) {
            this.renderMenuInterfaces();
            Provider.runMethod(this.selectedOption);
        }
    }

    private void renderMenuInterfaces() {
        MenuOpciones viewMenu = new MenuOpciones();
        String controller;
        do {
            viewMenu.setMenuLabel(Provider.getMainMenuLabel());
            viewMenu.run();
            if(viewMenu.isExit()) {
                viewMenu.imprimirPantalla("Saliendo del programa.");
                System.exit(0);
            }
            controller = viewMenu.getOptionIndex();

            viewMenu.setMenuLabel(Provider.getSubMenuLabel(controller));
            viewMenu.run();
        } while(viewMenu.isExit());

        String method = viewMenu.getOptionIndex();

        this.selectedOption = controller + "::" + method;
    }
}
