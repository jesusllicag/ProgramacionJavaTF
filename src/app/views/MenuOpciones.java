package app.views;

import app.models.Menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Scanner;

public class MenuOpciones {
    private String titulo;
    private List<String> opciones;
    private int opcionInvalida;
    public int opcionElegida = 0;

    private MenuOpciones(Menu menu){
        this.titulo = menu.getTitulo();
        this.opciones = menu.getOpciones();
        this.opcionInvalida = this.opciones.size();
    }

    public static void run(Menu menu) {
        MenuOpciones view = new MenuOpciones(menu);
        do {
            view.mostrar();
            view.opcionElegida = view.seleccionarOpcion();
            switch (view.opcionElegida) {
                case 1:
                    System.out.println("🔹 Registrando alumno...");
                    break;
                case 2:
                    System.out.println("📚 Registrando libro...");
                    break;
                case 3:
                    System.out.println("📦 Procesando préstamo...");
                    break;
                case 4:
                    System.out.println("🚪 Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("❌ Opción no reconocida.");

            }

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
                this.opcionElegida = scanner.nextInt();
                if (this.opcionElegida >= 1 && this.opcionElegida <= this.opciones.size()) {
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
