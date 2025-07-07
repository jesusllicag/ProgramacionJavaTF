package app.contracts.models;

import app.contracts.classes.Model;

public class User extends Model {
    protected int id;
    protected String dni;
    protected String name;
    protected String email;
    protected String phone;

    @Override
    public void init(int id, String... data) {
        this.id = id;
        this.dni = data[0];
        this.name = data[1];
        this.email = data[2];
        this.phone = data[3];
    }
}
