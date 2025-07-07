package app.bootstrap.providers;

import app.contracts.dtos.MenuLabel;
import java.util.Map;

public class LabelProvider {
    public MenuLabel getMainMenuLabel() {
        return new MenuLabel(
            "========== MENU PRINCIPAL ==========",
            "book::Gestión de Libros",
            "user::Gestión de Usuarios",
            "loan::Gestión de Préstamos",
            "report::Reportes",
            "exit::Salir"
        );
    }

    public MenuLabel getSubMenuLabel(String controller) {
        Map<String, MenuLabel> menu = Map.of(
                "book", new MenuLabel(
                        "========== GESTION LIBROS ==========",
                        "store::Registrar Libro",
                        "index::Listar Libros",
                        "show::Buscar Libro por titulo o código",
                        "update::Editar Libro",
                        "destroy::Eliminar Libro",
                        "exit::Regresar al menú principal"
                ),
                "user", new MenuLabel(
                        "========= GESTION USUARIOS =========",
                        "store::Registrar Usuario",
                        "index::Listar Usuario",
                        "show::Buscar Usuario por DNI o Nombre",
                        "update::Editar usuario",
                        "destroy::Eliminar usuario",
                        "exit::Regresar al menu principal"
                ),
                "loan", new MenuLabel(
                        "========= GESTION PRÉSTAMO =========",
                        "store::Registrar Préstamo",
                        "update::Registrar Devolución",
                        "index::Listar Prestamos activos",
                        "exit::Regresar al menú principal"
                ),
                "report", new MenuLabel(
                        "============= REPORTES =============",
                        "borrowList::Rep. libros prestados",
                        "availableList::Rep. libros disponibles",
                        "userList::Rep. usuarios con más préstamos",
                        "exit::Regresar al menú principal"
                )
        );

        return menu.get(controller);
    }

}
