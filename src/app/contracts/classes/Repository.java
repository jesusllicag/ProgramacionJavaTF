package app.contracts.classes;

import java.util.List;


public abstract class Repository<T extends Model> {
    protected DatabaseTable<T> database;
    protected DatabaseTable<? extends Model>[] relations;

    @SafeVarargs
    protected Repository(
            DatabaseTable<T> database,
            DatabaseTable<? extends Model> ...relations
    ) {
        this.database = database;
        this.relations = relations;
    }

    public List<T> getAll() {
        return this.database.getRecord();
    }

    public T getById(String id) throws ClassNotFoundException {
        return this.database.get(id);
    }



    public void save(T model) {
        this.database.insert(model);
    }

    public T get(String id) {
        for (T item : this.database.getRecord()) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void update(T updatedModel) {
        List<T> records = this.database.getRecord();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId().equals(updatedModel.getId())) {
                records.set(i, updatedModel);
                return;
            }
        }
    }

    public boolean delete(T model) {
        List<T> records = this.database.getRecord();
        return records.removeIf(item -> item.getId().equals(model.getId()));
    }
}
