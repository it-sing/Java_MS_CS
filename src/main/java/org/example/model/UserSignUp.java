package org.example.model;

public class UserSignUp {
    private String fullName;
    private String username;
    private String password;
    private String profileImage;

    // Constructor
    public UserSignUp(String fullName, String username, String password, String profileImage) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }

    // Getter methods
    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    // Setter methods
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}