package app.config.menu;

import app.contracts.dtos.MenuLabel;
import java.util.Arrays;
import java.util.List;


public class PrestamoMenuLabel extends MenuLabel {

    private static final String TITULO = "==== GESTION PRÉSTAMO ====";
    private static final List<String> OPCIONES = Arrays.asList(
            "store::Registrar Préstamo",
            "update::Registrar Devolución",
            "index::Listar Prestamos activos",
            "exit::Regresar al menú principal"
    );

    public PrestamoMenuLabel() {
        super(TITULO, OPCIONES);
    }

}
