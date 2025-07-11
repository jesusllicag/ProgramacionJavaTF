package app.schemas;

import app.contracts.classes.Validator;

public class UserSchema extends Validator {

    public String dni(String dni) {
        boolean[] rules = {
                !dni.isEmpty(),
                dni.matches("^\\d{8}$")
        };

        String[] messages = {
                "El DNI no puede estar vacio",
                "DNI inválido. Intenta nuevamente."
        };

        return this.validate(rules, messages);
    }

    public String name(String name) {
        boolean[] rules = {
                !name.isEmpty(),
                name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñüÜ\\s]+$"),
        };
        String[] messages = {
                "El nombre no puede estar vacío",
                "El nombre solo puede tener letras",
        };
        return this.validate(rules, messages);
    }

    public String email(String email) {
        boolean[] rules = {
                !email.isEmpty(),
                email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        };

        String[] messages = {
                "El correo no puede estar vacio",
                "Correo inválido. Intenta nuevamente."
        };

        return this.validate(rules, messages);
    }

    public String phone(String phone) {
        boolean[] rules = {
                !phone.isEmpty(),
                phone.matches("^\\d{9}$")
        };

        String[] messages = {
                "El Teléfono no puede estar vacío",
                "Teléfono inválido. Intenta nuevamente."
        };

        return this.validate(rules, messages);
    }

}
