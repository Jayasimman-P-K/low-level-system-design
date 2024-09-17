package LibraryManagement;

import java.util.Scanner;

import LibraryManagement.Models.Book;
import LibraryManagement.Models.Loan;
import LibraryManagement.Models.User;
import LibraryManagement.Services.BookService;
import LibraryManagement.Services.LoanService;
import LibraryManagement.Services.UserService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        BookService bookService = new BookService();
        LoanService loanService = new LoanService();

        boolean loop = true;
        while (loop) {
            System.out.println("\n1. Add User\n2. Add Book\n3. Issue Loan\n4. Return Loan\n5. Exit\n");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("Enter user id: ");
                    String userId = scanner.next();
                    System.out.print("Enter user name: ");
                    String userName = scanner.next();
                    System.out.print("Enter user mailId: ");
                    String userMailId = scanner.next();
                    User user = new User(userId, userName, userMailId);
                    userService.addUser(user);
                    break;
                }

                case 2: {
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.next();
                    System.out.print("Enter book author: ");
                    String author = scanner.next();
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    Book book = new Book(isbn, author, title);
                    bookService.addBook(book);
                    break;
                }

                case 3: {
                    System.out.print("Enter user ID: ");
                    String userId = scanner.next();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.next();
                    User user = userService.getUser(userId);
                    Book book = bookService.getBook(isbn);
                    if (user != null && book != null) {
                        Loan loan = loanService.issueLoan(user, book);
                        if (loan != null) {
                            System.out.println("Loan issued succesfully. Loan Id: " + loan.getLoanId());
                        }
                    } else {
                        System.out.println("Invalid user Id or book ISBN");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter Loan Id: ");
                    String loanId = scanner.next();
                    loanService.returnLoan(loanId);
                    System.out.println("Loan returned succesfully!!");
                    break;
                }

                case 5: {
                    loop = false;
                    break;
                }

                default: {
                    System.out.println("Not an option, Choose a correct option.");
                    break;
                }
            }
        }
    
        scanner.close();
    }     
}