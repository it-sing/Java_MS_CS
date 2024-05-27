package org.example.model;

import java.io.InputStream;

public class UserDetails {
    private String fullName;
    private InputStream profileInputStream;

    public UserDetails(String fullName, InputStream profileInputStream) {
        this.fullName = fullName;
        this.profileInputStream = profileInputStream;
    }

    public String getFullName() {
        return fullName;
    }

    public InputStream getProfileInputStream() {
        return profileInputStream;
    }

}
