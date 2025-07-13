package app.views;

import app.contracts.classes.View;
import app.contracts.models.Book;
import app.contracts.models.Stock;
import app.schemas.BookSchema;

public class BookView extends View {

    BookSchema validator = new BookSchema();

    public String[] runViewStore() {
        String[] form = new String[5];
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

        // Validar Stock
        while (true) {
            String stock = this.readInput("Ingresar numero de stock: ");
            String validate = this.validator.stock(stock);
            if (validate.equals("OK")) {
                form[4] = stock;
                break;
            } else {
                this.println(validate);
            }
        }

        return form;
    }

    public String[] runViewSearch() throws NullPointerException  {
        while (true) {
            this.println("Elegir Patrón de búsqueda: ");
            this.println("1. ID\n2. ISBN\n3. Titulo\n4. Salir");
            try {
                return this.readSearchInputOptions("123", "4");
            } catch (NullPointerException e) {
                this.println("Por favor ingrese una opción valida.");
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

        // Validar Stock
        while (true) {
            String quantity = this.readIgnoreEnterInput("Actualizar numero de stock: ", book.getStock().getQuantity());
            String validate = this.validator.stock(quantity);
            if (validate.equals("OK")) {
                Stock stock = book.getStock();
                stock.setQuantity(quantity);
                book.setStock(stock);
                break;
            } else {
                this.println(validate);
            }
        }

        return book;
    }
}
