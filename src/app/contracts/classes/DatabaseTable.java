package app.contracts.classes;

import app.contracts.interfaces.IDatabase;

import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseTable<M extends Model> implements IDatabase {
    protected int id = 0;
    protected final List<M> record = new ArrayList<>();


    public DatabaseTable() {
        this.seed();
    }
    protected abstract M model();
    protected abstract void seed();

    public int createId() {
        this.id++;
        return this.id;
    }

    public M get(String id) throws ClassNotFoundException {
        for (M model : this.getRecord()) {
            if (model.getId().equalsIgnoreCase(id)) {
                return model;
            }
        }
        throw new ClassNotFoundException(DatabaseTable.MSG_ITEM_NOT_FOUND);
    }

    public void create(String ...data) {
        M model = this.model();
        model.init(this.createId(), data);
        this.record.add(model);
    }

    public List<M> getRecord() {
        return this.record;
    }

    public void insert(M model) {
        this.record.add(model);
    }
}
