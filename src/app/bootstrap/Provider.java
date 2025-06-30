package app.bootstrap;

import app.config.menu.*;
import app.contracts.dtos.MenuLabel;
import java.lang.reflect.Method;
import java.util.Map;

public class Provider {

    public static MenuLabel getMainMenuLabel() {
        return new MainMenuLabel();
    }

    public static MenuLabel getSubMenuLabel(String controller) {
        Map<String, MenuLabel> menu = Map.of(
            "LibroController", new LibroMenuLabel(),
            "UserController", new UserMenuLabel(),
            "PrestamoController", new PrestamoMenuLabel(),
            "ReporteController", new ReporteMenuLabel()
        );

        return menu.get(controller);
    }

    public static void runMethod(String selection) {
        String[] part = new String[2];

        try {
            part = selection.split("::");

            Class<?> controller = Class.forName("app.controllers." + part[0]);

            Object instancia = controller.getDeclaredConstructor().newInstance();

            Method method = controller.getMethod(part[1]);

            method.invoke(instancia);

        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + part[0]);
        } catch (NoSuchMethodException e) {
            System.out.println("Método no encontrado: " + part[0] + "::" +part[1]);
        } catch (Exception e) {
            System.out.println("Error ejecutando método: " + e.getMessage());
        }
    }

}
