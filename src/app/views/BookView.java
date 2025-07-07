package app.views;

import app.contracts.classes.View;

public class BookView extends View {
    public String[] runViewStore() {
        String[] form = new String[4];
        this.println("Crear Libro");

        // Validar ISBN
        while (true) {
            this.println("Ingresar ISBN (Ej. 0-1234-1111-9): ");
            String isbn = this.scanner.nextLine().trim();
            if (isbn.matches("^\\d-\\d{4}-\\d{4}-\\d$")) {
                form[0] = isbn;
                break;
            } else {
                this.println("ISBN inválido. Intenta nuevamente.");
            }
        }

        // Validar Título
        while (true) {
            this.println("Ingresar Título: ");
            String titulo = this.scanner.nextLine().trim();
            if (!titulo.isEmpty()) {
                form[1] = titulo;
                break;
            } else {
                this.println("El título no puede estar vacío.");
            }
        }

        // Validar Autor
        while (true) {
            this.println("Ingresar Autor: ");
            String autor = this.scanner.nextLine().trim();
            if (!autor.isEmpty()) {
                form[2] = autor;
                break;
            } else {
                this.println("El autor no puede estar vacío.");
            }
        }

        // Validar Año
        while (true) {
            this.println("Ingresar Año de publicación (Ej. 2005): ");
            String yearStr = this.scanner.nextLine().trim();
            if (yearStr.matches("^\\d{4}$")) {
                int year = Integer.parseInt(yearStr);
                int currentYear = java.time.Year.now().getValue();
                if (year >= 1500 && year <= currentYear) {
                    form[3] = yearStr;
                    break;
                }
            }
            this.println("Año inválido. Ingresa un año entre 1500 y " + java.time.Year.now().getValue() + ".");
        }

        return form;
    }

    public String[] runViewShow() {
        String[] form = new String[2];
        while (true) {
            this.println("Buscar por ISBN o Titulo");
            this.println("Elegir una opcion:");
            this.println("1. Buscar por ISBN");
            this.println("2. Buscar por Titulo");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {
                form[0] = input;
                this.println("Ingrese patron de busqueda:");
                form[1] = scanner.nextLine().trim();
                return form;
            } else {
                this.println("Porfavor ingrese una opcion valida.");
            }
        }
    }
}
