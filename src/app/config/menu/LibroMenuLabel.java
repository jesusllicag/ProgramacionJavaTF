package app.config.menu;

import app.contracts.dtos.MenuLabel;

import java.util.Arrays;
import java.util.List;

public class LibroMenuLabel extends MenuLabel {

    private static final String TITULO = "===== GESTION LIBROS =====";
    private static final List<String> OPCIONES = Arrays.asList(
            "store::Registrar Libro",
            "index::Listar Libros",
            "show::Buscar Libro por titulo o código",
            "update::Editar Libro",
            "destroy::Eliminar Libro",
            "exit::Regresar al menú principal"
    );

    public LibroMenuLabel() {
        super(TITULO,OPCIONES);
    }
}
