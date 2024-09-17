package LibraryManagement.Models;

import java.util.Date;

public class Loan {
    private final String loanId;
    private final User user;
    private final Book book;
    private final Date issueDate;
    private Date returnDate;

    public Loan(String loanId, User user, Book book, Date issueDate) {
        this.loanId = loanId;
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
}
