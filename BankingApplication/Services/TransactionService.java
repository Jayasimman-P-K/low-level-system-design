package BankingApplication.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BankingApplication.Enums.TransactionType;
import BankingApplication.Models.Account;
import BankingApplication.Models.Transaction;

public class TransactionService {
    private final Map<String, Transaction> transactions = new HashMap<>();

    public Transaction deposit(String accountId, double amount, AccountService accountService) {
        Account account = accountService.getAccount(accountId);
        if (account != null) {
            Transaction transaction = new Transaction(account, TransactionType.DEPOSIT, amount);
            transactions.put(transaction.getTransactionId(), transaction);
            account.setBalance(account.getBalance() + amount);
            return transaction;
        }
        return null;
    }

    public Transaction withdraw(String accountId, double amount, AccountService accountService) {
        Account account = accountService.getAccount(accountId);
        if (account != null && account.getBalance() >= amount) {
            Transaction transaction = new Transaction(account, TransactionType.WITHDRAW, amount);
            transactions.put(transaction.getTransactionId(), transaction);
            account.setBalance(account.getBalance() - amount);
            return transaction;
        }
        return null;
    }

    public Transaction transfer(String fromAccountId, String toAccountId, double amount, AccountService accountService) {
        Account fromAccount = accountService.getAccount(fromAccountId);
        Account toAccount = accountService.getAccount(toAccountId);
        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            Transaction withdrawal = new Transaction(fromAccount, TransactionType.WITHDRAW, amount);
            transactions.put(withdrawal.getTransactionId(), withdrawal);
            fromAccount.setBalance(fromAccount.getBalance() - amount);

            Transaction deposit = new Transaction(toAccount, TransactionType.DEPOSIT, amount);
            transactions.put(deposit.getTransactionId(), deposit);
            toAccount.setBalance(toAccount.getBalance() + amount);

            return deposit;
        }
        return null;
    }

    public List<Transaction> getTransactionHistory(String accountId, AccountService accountService) {
        List<Transaction> transactionHistory = new ArrayList<>();
        Account account = accountService.getAccount(accountId);
        
        if (account != null) {
            for (Transaction transaction : transactions.values()) {
                if (transaction.getAccount().getAccountId().equals(accountId)) {
                    transactionHistory.add(transaction);
                }
            } 
        }
        
        return transactionHistory;
    }
}
