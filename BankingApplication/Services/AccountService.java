
package BankingApplication.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BankingApplication.Enums.AccountType;
import BankingApplication.Models.Account;
import BankingApplication.Models.User;

public class AccountService {
    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(User user, AccountType accountType) {
        Account account = new Account(user, accountType);
        accounts.put(account.getAccountId(), account);
        return account;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void closeAccount(String accountId) {
        accounts.remove(accountId);
    }

    public List<Account> getAccountsByUser(String userId) {
        List<Account> userAccounts = new ArrayList<>();
        for (Account account : accounts.values()) {
            if (account.getUser().getUserId().equals(userId)) {
                userAccounts.add(account);
            }
        }
        return userAccounts;
    }
}
