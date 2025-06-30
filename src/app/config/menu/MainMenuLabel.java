package app.config.menu;

import app.contracts.dtos.MenuLabel;
import java.util.Arrays;
import java.util.List;

public class MainMenuLabel extends MenuLabel {

    private static final String TITULO = "===== MENU PRINCIPAL =====";
    private static final List<String> OPCIONES = Arrays.asList(
            "LibroController::Gestión de Libros",
            "UserController::Gestión de Usuarios",
            "PrestamoController::Gestión de Préstamos",
            "ReporteController::Reportes",
            "exit::Salir"
    );

    public MainMenuLabel() {
        super(TITULO, OPCIONES);
    }

}
