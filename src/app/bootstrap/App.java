package app.bootstrap;

import app.config.menu.MainMenuLabel;
import app.models.MenuLabel;
import app.providers.MenuProvider;
import app.views.MenuOpciones;

public class App {
    public static void run(String[] args) {
        // Sembrar data
        // Leer configuraciones
        // Orquestar dependencias
        // Ejecutar
        MenuProvider seleccion = MenuProvider.init();
        System.out.println(seleccion.getSelection()[0]);
        System.out.println(seleccion.getSelection()[1]);
    }
}
