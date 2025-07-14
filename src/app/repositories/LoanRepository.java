package app.repositories;

import app.contracts.classes.DatabaseTable;
import app.contracts.classes.Model;
import app.contracts.classes.Repository;
import app.contracts.interfaces.IRepository;
import app.contracts.models.Book;
import app.contracts.models.Loan;
import app.contracts.models.User;
import database.Books;
import database.Users;

import java.util.List;

public class LoanRepository extends Repository<Loan> implements IRepository {

    @SafeVarargs
    public LoanRepository(
            DatabaseTable<Loan> database,
            DatabaseTable<? extends Model> ...relations
    ) {
        super(database, relations);
    }

    protected Users user() {
        return (Users) this.relations[0];
    }

    protected Books books() {
        return (Books) this.relations[1];
    }

    public List<Loan> getActiveList() {
        return this.database.getRecord()
                .stream()
                .filter(loan -> loan.getRtnDate() == null || loan.getRtnDate().isBlank())
                .toList();
    }

    public void toSave(String... args) throws ClassNotFoundException {
        int id = this.database.createId();
        Loan loan = new Loan();
        User user = this.user().get(args[0]);
        Book book = this.books().get(args[1]);
        int quantity = Integer.parseInt(args[2]);
        loan.init(id, user, book, quantity);
        this.save(loan);
    }

    public Loan getByCode(String code) throws ClassNotFoundException {
        for (Loan loan : this.database.getRecord()) {
            if (loan.getCode().equalsIgnoreCase(code)) {
                return loan;
            }
        }
        throw new ClassNotFoundException(IRepository.MSG_ITEM_NOT_FOUND);
    }
}