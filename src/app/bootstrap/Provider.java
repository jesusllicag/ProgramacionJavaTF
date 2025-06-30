package app.bootstrap;

import app.config.Menu;
import app.contracts.dtos.MenuLabel;
import java.util.Map;

public class Provider {

    public static MenuLabel getMainMenuLabel() {
        return Menu.mainMenuLabel();
    }

    public static MenuLabel getSubMenuLabel(String controller) {
        Map<String, MenuLabel> menu = Map.of(
            "LibroController", Menu.libroLabel(),
            "UserController", Menu.usuarioLabel(),
            "PrestamoController", Menu.prestamoLabel(),
            "ReporteController", Menu.reporteLabel()
        );

        return menu.get(controller);
    }

}
