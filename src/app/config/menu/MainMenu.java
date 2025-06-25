package app.config.menu;

import app.models.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenu {

    public static Menu init() {

        String titulo = "===== MENU PRINCIPAL =====";
        List<String> opciones = Arrays.asList(
            "Gestión de Libros",
            "Gestión de Usuarios",
            "Gestión de Préstamos",
            "Reportes",
            "Salir"
        );

        return new Menu(titulo, opciones);
    }
}
