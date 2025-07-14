package database;

import app.contracts.classes.DatabaseTable;
import app.contracts.models.User;

public class Users extends DatabaseTable<User>  {

    @Override
    protected User model() {
        return new User();
    }

    @Override
    protected void seed() {
        this.create("77665544", "Jesus Llica", "jesus@mail.com", "999888777");
        this.create("77665545", "Marco Heldres", "marco@mail.com", "987654321");
    }

}
