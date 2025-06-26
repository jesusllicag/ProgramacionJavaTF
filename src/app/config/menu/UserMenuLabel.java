package app.config.menu;

import app.models.MenuLabel;

import java.util.Arrays;

public class UserMenuLabel extends MenuLabel {
    public UserMenuLabel() {
        super(
                "==== GESTION USUARIOS ====",
                Arrays.asList(
                        "Registrar Usuario",
                        "Listar Usuario",
                        "Buscar Usuario por DNI o Nombre",
                        "Editar usuario",
                        "Eliminar usuario",
                        "Regresar al menu principal"
                )
        );
    }
}
