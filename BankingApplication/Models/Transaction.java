package BankingApplication.Models;

import java.util.Date;
import java.util.UUID;

import BankingApplication.Enums.TransactionType;

public class Transaction {
    private final String transactionId;
    private final Account account;
    private final TransactionType transactionType;
    private final double amount;
    private final Date timestamp;

    public Transaction (Account account, TransactionType transactionType, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
}
