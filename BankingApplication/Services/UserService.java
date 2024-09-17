package BankingApplication.Services;

import java.util.HashMap;
import java.util.Map;

import BankingApplication.Models.User;

public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public void createUser(String name, String mailId, String password) {
        User user = new User(name, mailId, password);
        users.put(user.getUserId(), user);
    }

    public User authenticateUser(String mailId, String password) {
        User user = null;
        for (User u : users.values()) {
            if (u.getMailId().equals(mailId) && u.getPassword().equals(password)) {
                user = u;
                return user;
            }
        }
        return null;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
