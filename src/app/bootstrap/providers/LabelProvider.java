package app.bootstrap.providers;

import app.contracts.dtos.MenuLabel;
import app.contracts.interfaces.AppModules;

import java.util.Map;

public class LabelProvider implements AppModules {
    public MenuLabel getMainMenuLabel() {
        return new MenuLabel(
                "========== MENU PRINCIPAL ==========",
                AppModules.BOOK + "::Gestión de Libros",
                AppModules.USER + "::Gestión de Usuarios",
                AppModules.LOAN + "::Gestión de Préstamos",
                AppModules.REPORT + "::Reportes",
                AppModules.EXIT + "::Salir"
        );
    }

    public MenuLabel getSubMenuLabel(String controller) {
        Map<String, MenuLabel> menu = Map.of(
                AppModules.BOOK, new MenuLabel(
                        "========== GESTION LIBROS ==========",
                        AppModules.STORE_USECASE + "::Registrar Libro",
                        AppModules.INDEX_USECASE + "::Listar Libros",
                        AppModules.SHOW_USECASE + "::Buscar Libro por titulo o código",
                        AppModules.UPDATE_USECASE + "::Editar Libro",
                        AppModules.DESTROY_USECASE + "::Eliminar Libro",
                        AppModules.EXIT + "::Regresar al menú principal"
                ),
                AppModules.USER, new MenuLabel(
                        "========= GESTION USUARIOS =========",
                        AppModules.STORE_USECASE + "::Registrar Usuario",
                        AppModules.INDEX_USECASE + "::Listar Usuario",
                        AppModules.SHOW_USECASE + "::Buscar Usuario por DNI o Nombre",
                        AppModules.UPDATE_USECASE + "::Editar usuario",
                        AppModules.DESTROY_USECASE + "::Eliminar usuario",
                        AppModules.EXIT + "::Regresar al menu principal"
                ),
                AppModules.LOAN, new MenuLabel(
                        "========= GESTION PRÉSTAMO =========",
                        AppModules.STORE_USECASE + "::Registrar Préstamo",
                        AppModules.UPDATE_USECASE + "::Registrar Devolución",
                        AppModules.INDEX_USECASE + "::Listar Prestamos activos",
                        AppModules.EXIT + "::Regresar al menú principal"
                ),
                AppModules.REPORT, new MenuLabel(
                        "============= REPORTES =============",
                        AppModules.REPORT_LOAN_LIST + "::Rep. libros prestados",
                        AppModules.REPORT_AVAILIABLE_LIST + "::Rep. libros disponibles",
                        AppModules.REPORT_USER_WITH_MORE_LOANS + "::Rep. usuarios con más préstamos",
                        AppModules.EXIT + "::Regresar al menú principal"
                )
        );

        return menu.get(controller);
    }

}
