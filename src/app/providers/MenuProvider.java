package app.providers;

import app.config.menu.*;
import app.models.MenuLabel;
import app.views.MenuOpciones;

public class MenuProvider {

    private final int[] selection = {0,0};

    private final MenuLabel mainMenu = new MainMenuLabel();

    private final MenuLabel[] subMenu = new MenuLabel[]{
            new LibroMenuLabel(),
            new UserMenuLabel(),
            new PrestamoMenuLabel(),
            new ReporteMenuLabel()
    };

    public static MenuProvider init() {
        MenuProvider menuProvider = new MenuProvider();

        menuProvider.runMainMenu();
        menuProvider.runSubMenu();

        return menuProvider;
    }

    public void runMainMenu() {
        this.selection[0] = MenuOpciones.run(this.mainMenu);
    }

    public void runSubMenu() {
        this.selection[1] = MenuOpciones.run(this.subMenu[selection[0]]);
    }

    public int[] getSelection() {
        return this.selection;
    }

}
