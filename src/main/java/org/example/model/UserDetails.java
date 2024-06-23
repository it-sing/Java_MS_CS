package org.example.model;

import java.io.InputStream;

public class UserDetails {
    private String fullName;
    private String username;
    private InputStream profileInputStream;
    private UserRole role;

    public UserDetails(String fullName, String username, InputStream profileInputStream, UserRole role) {
        this.fullName = fullName;
        this.username = username;
        this.profileInputStream = profileInputStream;
        this.role = role;
    }

    // Getters and Setters for all fields

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public InputStream getProfileInputStream() {
        return profileInputStream;
    }

    public void setProfileInputStream(InputStream profileInputStream) {
        this.profileInputStream = profileInputStream;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
