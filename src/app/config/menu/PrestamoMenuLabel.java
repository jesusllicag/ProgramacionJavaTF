package app.config.menu;

import app.models.MenuLabel;

import java.util.Arrays;

public class PrestamoMenuLabel extends MenuLabel {

    public PrestamoMenuLabel() {
        super(
                "==== GESTION PRÉSTAMO ====",
                Arrays.asList(
                        "Registrar Préstamo",
                        "Registrar Devolución",
                        "Listar Prestamos activos",
                        "Regresar al menú principal"
                )
        );
    }

}
