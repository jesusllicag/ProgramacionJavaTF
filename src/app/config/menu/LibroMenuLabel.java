package app.config.menu;

import app.models.MenuLabel;

import java.util.Arrays;
import java.util.List;

public class LibroMenuLabel extends MenuLabel {

    public LibroMenuLabel() {
        super(
                "===== GESTION LIBROS =====",
                Arrays.asList(
                        "Registrar Libro",
                        "Listar Libros",
                        "Buscar Libro por titulo o código",
                        "Editar Libro",
                        "Eliminar Libro",
                        "Regresar al menú principal"
                )
        );
    }
}
