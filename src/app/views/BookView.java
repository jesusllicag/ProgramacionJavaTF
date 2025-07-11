package app.views;

import app.contracts.classes.View;
import app.contracts.models.Book;
import app.schemas.BookSchema;

public class BookView extends View {

    BookSchema validator = new BookSchema();

    public String[] runViewStore() {
        String[] form = new String[4];
        // Validar ISBN
        while (true) {
            String isbn = this.readInput("Ingresar ISBN (Ej. 0-1234-1111-9): ");
            String validate = this.validator.isbn(isbn);
            if (validate.equals("OK")) {
                form[0] = isbn;
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Título
        while (true) {
            String title = this.readInput("Ingresar Título del libro: ");
            String validate = this.validator.title(title);
            if (validate.equals("OK")) {
                form[1] = title;
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Autor
        while (true) {
            String author = this.readInput("Ingresar Autor del Libro: ");
            String validate = this.validator.author(author);
            if (validate.equals("OK")) {
                form[2] = author;
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Año
        while (true) {
            String year = this.readInput("Ingresar Año de publicación (Ej. 2005): ");
            String validate = this.validator.year(year);
            if (validate.equals("OK")) {
                form[3] = year;
                break;
            } else {
                this.println(validate);
            }
        }

        return form;
    }

    public String[] runViewSearch() {
        String[] form = new String[2];
        while (true) {
            String input = this.readInput("""
                    Elegir una opción:\s
                    1. ID\s
                    2. ISBN\s
                    3. Titulo\s
                    4. Salir\s
                    """
            );
            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                form[0] = input;
                form[1] = this.readInput("Ingrese patron de busqueda:");
                return form;
            } else if (input.equals("4")) {
                form[0] = input;
                return form;
            } else {
                this.println("Porfavor ingrese una opcion valida.");
            }
        }
    }

    public Book runViewUpdate(Book book) {
        this.println("Actualizando Libro con el ID: " + book.getId());

        // Validacion de ISBN
        while (true) {
            String isbn = this.readIgnoreEnterInput("Actualizar ISBN: ", book.getIsbn());
            String validate = this.validator.isbn(isbn);
            if (validate.equals("OK")) {
                book.setIsbn(isbn);
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Título
        while (true) {
            String title = this.readIgnoreEnterInput("Actualizar Título: ", book.getTitle());
            String validate = this.validator.title(title);
            if (validate.equals("OK")) {
                book.setTitle(title);
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Autor
        while (true) {
            String author = this.readIgnoreEnterInput("Actualizar Autor: ", book.getAuthor());
            String validate = this.validator.author(author);
            if (validate.equals("OK")) {
                book.setAuthor(author);
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Año
        while (true) {
            String year = this.readIgnoreEnterInput("Actualizar Año de publicación: ", book.getYear());
            String validate = this.validator.year(year);
            if (validate.equals("OK")) {
                book.setYear(year);
                break;
            } else {
                this.println(validate);
            }
        }

        return book;
    }
}
