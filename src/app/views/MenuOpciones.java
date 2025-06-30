package app.views;

import app.contracts.dtos.MenuLabel;

import java.util.*;

public class MenuOpciones {
    private String titulo;
    private List<String[]> options;
    private boolean isExit;
    private int selectedOption = -1;

    public void setMenuLabel(MenuLabel menuLabel) {
        this.titulo = menuLabel.getTitulo();
        this.options = menuLabel.getOpciones();
        this.isExit = false;
    }

    public void run() {
        do {
            this.mostrarInterfaz();
            this.leerOpcionSeleccionada();
            if(this.isExit) {
                break;
            }
        } while (this.selectedOption == -1);
    }

    public boolean isExit() {
        return isExit;
    }

    public String getOptionIndex() {
        return this.options.get(this.selectedOption)[0];
    }

    private String getOptionLabel(int index) {
        return this.options.get(index)[1];
    }

    private boolean validOption(int index) {
        return index >= 0 && index < this.options.size();
    }

    private boolean isExitOption(int index) {
        return index == this.options.size();
    }

    public void mostrarInterfaz() {
        System.out.println();
        System.out.println("+--------------------------------------+");
        System.out.printf("| %-36s |\n", this.titulo.toUpperCase());
        System.out.println("+--------------------------------------+");
        for (int i = 0; i < this.options.size(); i++) {
            System.out.printf("|  %d. %-32s |\n", i + 1, this.getOptionLabel(i));
        }
        System.out.println("+--------------------------------------+\n");
    }

    public void leerOpcionSeleccionada() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                int selectedOption = scanner.nextInt();
                if (this.validOption(selectedOption)) {
                    this.selectedOption = selectedOption - 1;
                    break;
                } else if (this.isExitOption(selectedOption)) {
                    this.isExit = true;
                    break;
                } else {
                    System.out.println("Opción fuera de rango. Intente nuevamente.");
                    this.selectedOption = -1;
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número.");
                scanner.next();
            }
        }
    }

    public void imprimirPantalla(String message) {
        System.out.println(message);
    }
}
