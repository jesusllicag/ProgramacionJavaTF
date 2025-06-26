package app.config.menu;

import app.models.MenuLabel;
import java.util.Arrays;

public class MainMenuLabel extends MenuLabel {

    public MainMenuLabel() {
        super(
            "===== MENU PRINCIPAL =====",
            Arrays.asList(
                "Gestión de Libros",
                "Gestión de Usuarios",
                "Gestión de Préstamos",
                "Reportes",
                "Salir"
            )
        );
    }

}
