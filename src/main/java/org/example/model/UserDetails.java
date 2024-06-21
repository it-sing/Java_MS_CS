package org.example.model;

import java.io.InputStream;

public class UserDetails {
    private String fullName;
    private InputStream profileInputStream;
    private String role;

    public UserDetails(String fullName, InputStream profileInputStream, String role) {
        this.fullName = fullName;
        this.profileInputStream = profileInputStream;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InputStream getProfileInputStream() {
        return profileInputStream;
    }

    public void setProfileInputStream(InputStream profileInputStream) {
        this.profileInputStream = profileInputStream;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
