package LibraryManagement.Models;

public class User {
    private final String userId;
    private final String userName;
    private final String userMailId;

    public User (String userId, String userName, String userMailId) {
        this.userId = userId;
        this.userName = userName;
        this.userMailId = userMailId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMailId() {
        return userMailId;
    }
    
}
