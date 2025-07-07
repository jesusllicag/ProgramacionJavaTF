package app.contracts.classes;

import app.config.DatabaseTable;
import app.contracts.models.Book;

import java.util.List;


public abstract class Repository<T extends Model> {
    protected DatabaseTable<T> database;

    protected Repository(DatabaseTable<T> database) {
        this.database = database;
    }

    public void toCreate(String... args) {
        this.database.create(args);
    }

    public String[] getAll() {
        List<T> lista = this.database.getRecord();
        String[] arr = new String[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i).toString();
        }

        return arr;
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

    public boolean update(T updatedModel) {
        List<T> records = this.database.getRecord();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId().equals(updatedModel.getId())) {
                records.set(i, updatedModel);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        List<T> records = this.database.getRecord();
        return records.removeIf(item -> item.getId().equals(id));
    }
}
