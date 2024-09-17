package BankingApplication.Models;

import java.util.UUID;

public class User {
    private final String userId;
    private final String name;
    private final String mailId;
    private String password;

    public User (String name, String mailId, String password) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.mailId = mailId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getMailId() {
        return mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}