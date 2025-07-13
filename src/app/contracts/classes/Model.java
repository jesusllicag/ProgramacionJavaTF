package app.contracts.classes;

import app.contracts.interfaces.IModel;

public abstract class Model implements IModel {
    protected int id;

    public abstract void init(int id, String ...data);

    public String getId() {
        return String.valueOf(id);
    }
}
