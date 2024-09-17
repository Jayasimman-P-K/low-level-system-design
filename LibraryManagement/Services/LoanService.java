package LibraryManagement.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import LibraryManagement.Models.Book;
import LibraryManagement.Models.Loan;
import LibraryManagement.Models.User;

public class LoanService {
    private final Map<String, Loan> loans = new HashMap<>();

    public Loan issueLoan(User user, Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
        }

        Loan loan = new Loan(UUID.randomUUID().toString(), user, book, new Date());
        loans.put(loan.getLoanId(), loan);
        book.setAvailable(false);
        return loan;
    }

    public void returnLoan(String loanId) {
        Loan loan = loans.get(loanId);

        if (loan != null) {
            loan.setReturnDate(new Date());
            loan.getBook().setAvailable(true);
        }
    }

    public Loan getLoan(String loanId) {
        return loans.get(loanId);
    }
}
