package org.example.repository;

import org.example.dto.UserSignInRequest;
import org.example.util.PropertyLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {
    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public boolean validateUser(UserSignInRequest userSignInRequest) {
        String query = "SELECT * FROM tbUser WHERE username = ? AND password = ?";
        System.out.println("Executing query: " + query); // Debugging statement
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, userSignInRequest.username());
            statement.setString(2, userSignInRequest.password());

            ResultSet resultSet = statement.executeQuery();
            boolean userExists = resultSet.next();
            System.out.println("User exists: " + userExists); // Debugging statement
            return userExists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
