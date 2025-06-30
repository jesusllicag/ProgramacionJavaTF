package app.config.menu;

import app.contracts.dtos.MenuLabel;
import java.util.Arrays;
import java.util.List;

public class ReporteMenuLabel extends MenuLabel {

    private static final String TITULO = "======== REPORTES ========";
    private static final List<String> OPCIONES = Arrays.asList(
            "borrowList::Rep. libros prestados",
            "availableList::Rep. libros disponibles",
            "userList::Rep. usuarios con más préstamos",
            "exit::Regresar al menú principal"
    );

    public ReporteMenuLabel() {
        super(TITULO, OPCIONES);
    }

}
