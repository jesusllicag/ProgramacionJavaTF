package app.config;

import app.contracts.dtos.MenuLabel;
import java.util.Arrays;
import java.util.List;

public class Menu {

    public static MenuLabel mainMenuLabel() {
        String TITULO = "========== MENU PRINCIPAL ==========";
        List<String> OPCIONES = Arrays.asList(
                "LibroController::Gestión de Libros",
                "UserController::Gestión de Usuarios",
                "PrestamoController::Gestión de Préstamos",
                "ReporteController::Reportes",
                "exit::Salir"
        );
        return new MenuLabel(TITULO, OPCIONES);
    }

    public static MenuLabel libroLabel() {
        String TITULO = "========== GESTION LIBROS ==========";
        List<String> OPCIONES = Arrays.asList(
                "store::Registrar Libro",
                "index::Listar Libros",
                "show::Buscar Libro por titulo o código",
                "update::Editar Libro",
                "destroy::Eliminar Libro",
                "exit::Regresar al menú principal"
        );
        return new MenuLabel(TITULO, OPCIONES);
    }

    public static MenuLabel usuarioLabel() {
        String TITULO = "========= GESTION USUARIOS =========";
        List<String> OPCIONES = Arrays.asList(
                "store::Registrar Usuario",
                "index::Listar Usuario",
                "show::Buscar Usuario por DNI o Nombre",
                "update::Editar usuario",
                "destroy::Eliminar usuario",
                "exit::Regresar al menu principal"
        );
        return new MenuLabel(TITULO, OPCIONES);
    }

    public static MenuLabel prestamoLabel() {
        String TITULO = "========= GESTION PRÉSTAMO =========";
        List<String> OPCIONES = Arrays.asList(
                "store::Registrar Préstamo",
                "update::Registrar Devolución",
                "index::Listar Prestamos activos",
                "exit::Regresar al menú principal"
        );
        return new MenuLabel(TITULO, OPCIONES);
    }

    public static MenuLabel reporteLabel() {
        String TITULO = "============= REPORTES =============";
        List<String> OPCIONES = Arrays.asList(
                "borrowList::Rep. libros prestados",
                "availableList::Rep. libros disponibles",
                "userList::Rep. usuarios con más préstamos",
                "exit::Regresar al menú principal"
        );
        return new MenuLabel(TITULO, OPCIONES);
    }
}
