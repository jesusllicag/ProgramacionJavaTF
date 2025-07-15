package app.views;

import app.contracts.classes.View;
import app.contracts.models.Book;
import app.contracts.models.Loan;

import java.util.List;

public class ReportView extends View {

    public void runViewLoanedBookList(List<Loan> loans) {
        for (Loan loan : loans) {
            this.println(loan.toString());
        }
    }

    public void runViewBookList(List<Book> books) {
        for (Book book : books) {
            this.println(book.toStringLoan());
        }
    }

    public void runViewTopLoanedUserList(List<Loan> loans) {
        for (Loan loan : loans) {
            this.println(loan.toStringUserLoaned());
        }
    }

}
