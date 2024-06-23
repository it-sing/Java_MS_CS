package org.example.model;

public class User {
    private Integer id;
    private String fullname;
    private String username;
    private UserRole role;

    // Constructors
    public User(Integer id, String name, String username, UserRole role) {
        this.id = id;
        this.fullname = name;
        this.username = username;
        this.role = role;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
