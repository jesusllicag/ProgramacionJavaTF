package app.schemas;

import app.contracts.classes.Validator;
import app.contracts.models.Book;

public class LoanSchema extends Validator {

    public String quantity(Book book, String quantity) {
        int intQuantity = Integer.parseInt(quantity);
        int booksAvailable = book.getAvailableBooksQuantity();
        boolean[] rules = {
                quantity.matches("^\\d+$"),
                !quantity.isEmpty(),
                intQuantity != 0,
                intQuantity > 0,
                booksAvailable >= intQuantity,
        };
        String[] messages = {
                "La cantidad debe ser un número",
                "La cantidad no puede estar vacío",
                "La cantidad no puede ser cero",
                "La cantidad no puede ser un número negativo",
                "La cantidad solicitada supera la cantidad disponible"
        };
        return this.validate(rules, messages);
    }

}
