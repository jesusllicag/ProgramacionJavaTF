package app.contracts.models;

import app.contracts.classes.Model;

public class User extends Model {
    protected String dni;
    protected String name;
    protected String email;
    protected String phone;

    public void init(int id, String... data) {
        this.id = id;
        this.dni = data[0];
        this.name = data[1];
        this.email = data[2];
        this.phone = data[3];
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.id + " | " + this.dni + " | " + this.name + " | " + this.email + " | " + this.phone;
    }
}
