package app.config.menu;

import app.contracts.dtos.MenuLabel;
import java.util.Arrays;
import java.util.List;

public class UserMenuLabel extends MenuLabel {

    private static final String TITULO = "==== GESTION USUARIOS ====";
    private static final List<String> OPCIONES = Arrays.asList(
            "store::Registrar Usuario",
            "index::Listar Usuario",
            "show::Buscar Usuario por DNI o Nombre",
            "update::Editar usuario",
            "destroy::Eliminar usuario",
            "exit::Regresar al menu principal"
    );

    public UserMenuLabel() {
        super(TITULO, OPCIONES);
    }
}
