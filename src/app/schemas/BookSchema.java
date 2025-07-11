package app.schemas;

import app.contracts.classes.Validator;

public class BookSchema extends Validator {

    public String isbn(String isbn) {
        boolean[] rules = {
            !isbn.isEmpty(),
            isbn.matches("^\\d-\\d{4}-\\d{4}-\\d$")
        };

        String[] messages = {
            "El ISBN no puede estar vacío",
            "ISBN inválido. Intenta nuevamente."
        };

        return this.validate(rules, messages);
    }

    public String title(String title) {
        boolean[] rules = {
            !title.isEmpty()
        };
        String[] messages = {
            "El titulo no puede estar vacío",
        };
        return this.validate(rules, messages);
    }

    public String author(String author) {
        boolean[] rules = {
                !author.isEmpty(),
                author.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñüÜ\\s]+$"),
        };
        String[] messages = {
                "El author no puede estar vacío",
                "El author solo puede tener letras",
        };
        return this.validate(rules, messages);
    }

    public String year(String year) {
        int intYear = Integer.parseInt(year);
        int currentYear = java.time.Year.now().getValue();
        boolean[] rules = {
                year.matches("^\\d{4}$"),
                !year.isEmpty(),
                intYear >= 1500,
                intYear <= currentYear
        };
        String[] messages = {
                "El Año de publicación solo puede tener números",
                "El Año de publicación no puede estar vacío",
                "El Año de publicación no puede ser menor a 1500",
                "El Año de publicación no puede ser mayor al año actual (" + currentYear + ")",
        };
        return this.validate(rules, messages);
    }
}
