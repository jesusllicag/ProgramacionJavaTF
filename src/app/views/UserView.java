package app.views;

import app.contracts.classes.View;
import app.contracts.models.User;
import app.schemas.UserSchema;
import java.util.List;

public class UserView extends View {

    UserSchema validator = new UserSchema();

    public void runViewList(List<User> users) {
        for (User user : users) {
            this.println(user.toString());
        }
    }

    public String[] runViewStore() {
        String[] form = new String[4];
        // Validar Dni
        while (true) {
            String dni = this.readInput("Ingresar DNI (Ej. 72113450): ");
            String validate = this.validator.dni(dni);
            if (validate.equals("OK")) {
                form[0] = dni;
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Nombre
        while (true) {
            String name = this.readInput("Ingresar nombre del usuario: ");
            String validate = this.validator.name(name);
            if (validate.equals("OK")) {
                form[1] = name;
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Correo
        while (true) {
            String email = this.readInput("Ingresar correo del usuario: ");
            String validate = this.validator.email(email);
            if (validate.equals("OK")) {
                form[2] = email;
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Teléfono
        while (true) {
            String phone = this.readInput("Ingresar Nº Teléfono de usuario (Ej. 998764325): ");
            String validate = this.validator.phone(phone);
            if (validate.equals("OK")) {
                form[3] = phone;
                break;
            } else {
                this.println(validate);
            }
        }

        return form;
    }

    public String[] runViewSearch() throws NullPointerException {
        while (true) {
            this.println("Elegir Patrón de búsqueda: ");
            this.println("1. ID\n2. DNI\n3. Nombre\n4. Salir");
            try {
                return this.readSearchInputOptions("123", "4");
            } catch (NullPointerException e) {
                this.println("Por favor ingrese una opción valida.");
            }
        }
    }

    public User runViewUpdate(User user) {
        this.println("Actualizando Usuario con el ID: " + user.getId());

        // Validar de DNI
        while (true) {
            String dni = this.readIgnoreEnterInput("Actualizar DNI: ", user.getDni());
            String validate = this.validator.dni(dni);
            if (validate.equals("OK")) {
                user.setDni(dni);
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Nombre
        while (true) {
            String name = this.readIgnoreEnterInput("Actualizar Nombre: ", user.getName());
            String validate = this.validator.name(name);
            if (validate.equals("OK")) {
                user.setName(name);
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Correo
        while (true) {
            String email = this.readIgnoreEnterInput("Actualizar Correo: ", user.getEmail());
            String validate = this.validator.email(email);
            if (validate.equals("OK")) {
                user.setEmail(email);
                break;
            } else {
                this.println(validate);
            }
        }

        // Validar Teléfono
        while (true) {
            String phone = this.readIgnoreEnterInput("Actualizar Teléfono: ", user.getPhone());
            String validate = this.validator.phone(phone);
            if (validate.equals("OK")) {
                user.setPhone(phone);
                break;
            } else {
                this.println(validate);
            }
        }

        return user;
    }
}
