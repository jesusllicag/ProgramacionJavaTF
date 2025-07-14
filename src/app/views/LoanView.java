package app.views;

import app.contracts.classes.View;
import app.contracts.models.Book;
import app.contracts.models.Loan;
import app.schemas.LoanSchema;

import java.util.List;

public class LoanView extends View {

    protected LoanSchema validator = new LoanSchema();

    public void runViewList(List<Loan> loans) {
        for (Loan loan : loans) {
            this.println(loan.activeLoantoString());
        }
    }

    public String runViewStore(Book book) {
        String form;
        // Validar Quantity
        while (true) {
            String quantity = this.readInput("Ingresar cantidad de libros prestados: ");
            String validate = this.validator.quantity(book, quantity);
            if (validate.equals("OK")) {
                form = quantity;
                break;
            } else {
                this.println(validate);
            }
        }


        return form;
    }

    public String runViewUpdateSelector(List<Loan> loans) {
        this.runViewList(loans);
        return this.readInput("Ingresar código de préstamo para su devolución: ");
    }
}
