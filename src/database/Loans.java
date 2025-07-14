package database;

import app.contracts.classes.DatabaseTable;
import app.contracts.models.Loan;

import java.util.ArrayList;
import java.util.List;

public class Loans extends DatabaseTable<Loan> {

    @Override
    protected Loan model() {
        return new Loan();
    }

    @Override
    protected void seed() {

    }

    public List<Loan> getListByBookId(String bookId) {
        List<Loan> loans = this.getRecord();
        List<Loan> filteredLoanList = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getBook().getId().equals(bookId)) {
                filteredLoanList.add(loan);
            }
        }
        return filteredLoanList;
    }

}