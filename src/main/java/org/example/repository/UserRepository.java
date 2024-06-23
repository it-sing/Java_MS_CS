package org.example.repository;

import org.example.model.UserDetails;
import org.example.model.UserRole;
import org.example.model.UserSignIn;
import org.example.model.UserSignUp;
import org.example.util.BCryptUtil;
import org.example.util.PropertyLoader;
import org.example.model.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class UserRepository {
    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public boolean validateUser(UserSignIn userSignIn) {
        String query = "SELECT password FROM tbUser WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, userSignIn.getUsername());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String hashedPasswordFromDB = resultSet.getString("password");

                    // Verify password using BCrypt
                    if (BCryptUtil.verifyPassword(userSignIn.getPassword(), hashedPasswordFromDB)) {
                        // Fetch and store the complete UserDetails after successful login
                        UserDetails userDetails = getUserDetails(userSignIn.getUsername());
                        if (userDetails != null) {
                            UserSession.getInstance().setCurrentUser(userDetails);
                            System.out.println("Stored UserDetails in session: " + userDetails);
                            return true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean registerUser(UserSignUp userSignUp) {
        String checkUserQuery = "SELECT COUNT(*) FROM tbUser WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement checkUserStatement = connection.prepareStatement(checkUserQuery)) {

            checkUserStatement.setString(1, userSignUp.getUsername());

            try (ResultSet resultSet = checkUserStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return false; // User already exists
                }
            }

            String query = "INSERT INTO tbUser (fullname, username, password, profile, role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, userSignUp.getFullName());
                statement.setString(2, userSignUp.getUsername());

                // Hash the password before storing
                String hashedPassword = BCryptUtil.hashPassword(userSignUp.getPassword());
                statement.setString(3, hashedPassword);

                // Use try-with-resources to automatically close the InputStream
                try (InputStream inputStream = new FileInputStream(userSignUp.getProfileImage())) {
                    statement.setBlob(4, inputStream);
                    statement.setString(5, UserRole.USER.name()); // Set default role to USER

                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                } // InputStream will be automatically closed here
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public UserDetails getUserDetails(String username) {
        String query = "SELECT fullname, username, profile, role FROM tbUser WHERE username = ?";
        UserDetails userDetails = null;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userDetails = extractUserDetails(resultSet);
                    System.out.println("Fetched UserDetails from DB: " + userDetails);
                } else {
                    System.out.println("No user found with username: " + username);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error while fetching user details: " + e.getMessage());
            e.printStackTrace();
        }

        return userDetails;
    }
    private UserDetails extractUserDetails(ResultSet resultSet) throws SQLException {
        String fullName = resultSet.getString("fullname");
        String username = resultSet.getString("username");
        InputStream profileInputStream = resultSet.getBinaryStream("profile");
        String roleStr = resultSet.getString("role");

        UserRole role = parseUserRole(roleStr);

        if (role != null) {
            System.out.println("Role fetched: " + role);
            return new UserDetails(fullName, username, profileInputStream, role);
        } else {
            System.out.println("Invalid role fetched");
            return null;
        }
    }

    private UserRole parseUserRole(String roleStr) {
        try {
            return UserRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("Invalid role string: " + roleStr);
            return null;
        }
    }

}
