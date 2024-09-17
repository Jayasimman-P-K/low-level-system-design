package BankingApplication.Models;

import java.util.UUID;

import BankingApplication.Enums.AccountType;

public class Account {
    private final String accountId;
    private final User user;
    private final AccountType accountType;
    private double balance;

    public Account (User user, AccountType accountType) {
        this.accountId = UUID.randomUUID().toString();
        this.user = user;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public User getUser() {
        return user;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
