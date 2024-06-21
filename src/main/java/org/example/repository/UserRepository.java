package org.example.repository;

import org.example.model.UserDetails;
import org.example.model.UserSignIn;
import org.example.model.UserSignUp;
import org.example.util.BCryptUtil;
import org.example.util.PropertyLoader;

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
                    return BCryptUtil.verifyPassword(userSignIn.getPassword(), hashedPasswordFromDB);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerUser(UserSignUp userSignUp) {
        String checkPasswordQuery = "SELECT COUNT(*) FROM tbUser WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement checkPasswordStatement = connection.prepareStatement(checkPasswordQuery)) {

            checkPasswordStatement.setString(1, userSignUp.getUsername());

            try (ResultSet resultSet = checkPasswordStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return false; // Username already exists
                }
            }

            String query = "INSERT INTO tbUser (fullname, username, password, profile) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, userSignUp.getFullName());
                statement.setString(2, userSignUp.getUsername());

                // Hash the password before storing
                String hashedPassword = BCryptUtil.hashPassword(userSignUp.getPassword());
                statement.setString(3, hashedPassword);

                // Use try-with-resources to automatically close the InputStream
                try (InputStream inputStream = new FileInputStream(userSignUp.getProfileImage())) {
                    statement.setBlob(4, inputStream);

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
        String query = "SELECT fullname, profile FROM tbUser WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String fullName = resultSet.getString("fullname");
                    InputStream profileInputStream = resultSet.getBinaryStream("profile");
                    return new UserDetails(fullName, profileInputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
