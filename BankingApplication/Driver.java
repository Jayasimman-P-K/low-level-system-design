package BankingApplication;

import java.util.List;
import java.util.Scanner;

import BankingApplication.Enums.AccountType;
import BankingApplication.Models.Account;
import BankingApplication.Models.Transaction;
import BankingApplication.Models.User;
import BankingApplication.Services.AccountService;
import BankingApplication.Services.TransactionService;
import BankingApplication.Services.UserService;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();

        System.out.println("\n====== Welcome to the Banking Application ======");

        boolean loop = true;
        while(loop) {
            System.out.print("\n1. New User\n2. Account Login\n3. Exit\n");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter your mail Id: ");
                    String mailId = scanner.next();
                    System.out.print("Enter your password: ");
                    String password = scanner.next();

                    userService.createUser(name, mailId, password);
                    System.out.println("New user created succesfully!!");
                    break;
                }

                case 2: {
                    System.out.print("Enter your mail Id to login: ");
                    String mailId = scanner.next();
                    System.out.print("Enter your password to login: ");
                    String password = scanner.next();
                    User user = userService.authenticateUser(mailId, password);
                    if (user != null) {
                        System.out.println("Login successfull!!");

                        System.out.print("Enter account type (CURRENT/SAVINGS): ");  
                        AccountType accountType = AccountType.valueOf(scanner.next().toUpperCase());
                        Account account = accountService.createAccount(user, accountType);
                        System.out.println("Account created successfully with account Id: " + account.getAccountId());

                        System.out.println("1. Deposit \n2. Withdraw \n3. Transfer Amount\n");
                        int transactionOption = scanner.nextInt();
                        switch (transactionOption) {
                            case 1: {
                                System.out.print("Enter amount to deposit: ");
                                double amount = scanner.nextDouble();
                                transactionService.deposit(account.getAccountId(), amount, accountService);
                                System.out.println("Amount deposited successfully!!");
                                break;
                            }

                            case 2: {
                                System.out.print("Enter amount to withdraw: ");
                                double amount = scanner.nextDouble();
                                transactionService.withdraw(account.getAccountId(), amount, accountService);
                                System.out.println("Amount withdrawn successfully!!");
                                break;
                            }

                            case 3: {
                                System.out.print("Enter destination account Id: ");
                                String toAccountId = scanner.next();
                                System.out.print("Enter amount to transfer: ");
                                double amount = scanner.nextDouble();
                                transactionService.transfer(account.getAccountId(), toAccountId, amount, accountService);
                                System.out.println("Amount transferred successfully!!");
                                break;
                            }

                            default: {
                                System.out.println("Not an option. Choose a correct option.");
                                break;
                            }
                        }

                        System.out.println("1. Chech account balance\n2. Show account transaction history\n");
                        int accountOption = scanner.nextInt();
                        switch (accountOption) {
                            case 1: {
                                System.out.println("Current balance: " + account.getBalance());
                                break;
                            }
                            
                            case 2: {
                                List<Transaction> transactionHistory = transactionService.getTransactionHistory(account.getAccountId(), accountService);
                                System.out.println("Transaction history: ");
                                for (Transaction transaction : transactionHistory) {
                                    System.out.println(transaction.getTransactionId() + " - " + transaction.getTransactionType() + " - " + transaction.getAmount() + " - " + transaction.getTimestamp());
                                }
                                break;
                            }

                            default: {
                                System.out.println("Not an option. choose a corrent option.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Oops, Login failed. Invalid mailId or password.");
                    }

                    break;
                }

                case 3: {
                    loop = false;
                    break;
                }
        
                default: {
                    System.out.println("Not an option. choose a correct option.");
                    break;
                }
            }
        }
   
        scanner.close();
    } 

}
