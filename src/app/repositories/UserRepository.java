package app.repositories;

import app.contracts.classes.DatabaseTable;
import app.contracts.classes.Model;
import app.contracts.classes.Repository;
import app.contracts.interfaces.IRepository;
import app.contracts.models.User;

public class UserRepository extends Repository<User> implements IRepository {

    @SafeVarargs
    public UserRepository(DatabaseTable<User> databaseTable, DatabaseTable<Model> ...relations) {
        super(databaseTable, relations);
    }

    public void toSave(String... args) {
        int id = this.database.createId();
        User user = new User();
        user.init(id, args);
        this.save(user);
    }

    public User getByDni(String dni) throws ClassNotFoundException {
        for (User user : this.database.getRecord()) {
            if (user.getDni().equalsIgnoreCase(dni)) {
                return user;
            }
        }
        throw new ClassNotFoundException(IRepository.MSG_ITEM_NOT_FOUND);
    }

    public User getByName(String isbn) throws ClassNotFoundException {
        for (User user : this.database.getRecord()) {
            if (user.getName().equalsIgnoreCase(isbn)) {
                return user;
            }
        }
        throw new ClassNotFoundException(IRepository.MSG_ITEM_NOT_FOUND);
    }

    public User getSelectedFilter(String[] filterCase) throws IllegalStateException, ClassNotFoundException {
        return switch (filterCase[0]) {
            case "1" -> this.getById(filterCase[1]);
            case "2" -> this.getByDni(filterCase[1]);
            case "3" -> this.getByName(filterCase[1]);
            default -> throw new IllegalStateException("Saliendo sin realizar acción");
        };
    }
}
