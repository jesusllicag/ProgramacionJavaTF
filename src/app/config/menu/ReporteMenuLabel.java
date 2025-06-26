package app.config.menu;

import app.models.MenuLabel;

import java.util.Arrays;

public class ReporteMenuLabel extends MenuLabel {

    public ReporteMenuLabel() {
        super(
                "======== REPORTES ========",
                Arrays.asList(
                        "Reporte de libros prestados",
                        "Reporte de libros disponibles",
                        "Reporte de usuarios con más préstamos",
                        "Regresar al menú principal"
                )
        );
    }

}
