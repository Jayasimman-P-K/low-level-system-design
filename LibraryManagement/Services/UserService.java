package LibraryManagement.Services;

import java.util.HashMap;
import java.util.Map;

import LibraryManagement.Models.User;

public class UserService {
    private final Map<String, User> users = new HashMap<>();
    
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void removeUser(String userId) {
        users.remove(userId);
    }
}
