package org.example.model;

public class UserSession {
    private static UserSession instance;
    private UserDetails currentUser;
    private UserSession() { }
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    public UserDetails getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(UserDetails currentUser) {
        this.currentUser = currentUser;
    }
}
