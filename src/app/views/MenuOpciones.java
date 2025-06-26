package app.views;

import app.models.MenuLabel;

import java.util.List;
import java.util.Scanner;

public class MenuOpciones {
    private String titulo;
    private List<String> opciones;
    private int opcionInvalida;
    public int opcionElegida = 0;

    private MenuOpciones(MenuLabel menuLabel){
        this.titulo = menuLabel.getTitulo();
        this.opciones = menuLabel.getOpciones();
        this.opcionInvalida = this.opciones.size();
    }

    public static int run(MenuLabel menuLabel) {
        MenuOpciones view = new MenuOpciones(menuLabel);
        do {
            view.mostrar();
            return view.seleccionarOpcion();
        } while (view.opcionElegida < view.opcionInvalida);
    }

    public void mostrar() {
        System.out.println();
        System.out.println("+--------------------------------------+");
        System.out.printf("| %-36s |\n", this.titulo.toUpperCase());
        System.out.println("+--------------------------------------+");
        for (int i = 0; i < this.opciones.size(); i++) {
            System.out.printf("|  %d. %-32s |\n", i + 1, this.opciones.get(i));
        }
        System.out.println("+--------------------------------------+\n");
    }

    public int seleccionarOpcion() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                int opcionElegida = scanner.nextInt();
                if (opcionElegida >= 1 && opcionElegida < this.opciones.size()) {
                    this.opcionElegida = opcionElegida - 1;
                    break;
                } else if (opcionElegida == this.opciones.size()) {
                    System.out.println("Saliendo del Programa.");
                    break;
                } else {
                    System.out.println("Opción fuera de rango. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número.");
                scanner.next(); // limpiar entrada
            }
        }

        return this.opcionElegida;
    }
}
