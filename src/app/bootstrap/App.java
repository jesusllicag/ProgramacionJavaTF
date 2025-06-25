package app.bootstrap;

import app.config.menu.MainMenu;
import app.models.Menu;
import app.views.MenuOpciones;

public class App {
    public static void run(String[] args) {
        // Sembrar data
        // Leer configuraciones
        Menu mainMenu = MainMenu.init();
        // Orquestar dependencias
        // Ejecutar
        MenuOpciones.run(mainMenu);
    }
}
