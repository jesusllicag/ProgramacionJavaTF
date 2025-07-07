package app.contracts.classes;

import app.contracts.interfaces.IModel;

public abstract class Model implements IModel {
    protected int id;

    public String getId() {
        return String.valueOf(id);
    }
}
