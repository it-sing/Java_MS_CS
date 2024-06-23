package org.example.repository;

import org.example.model.DataY1;
import org.example.model.User;
import org.example.model.UserRole;
import org.example.util.Message;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public List<User> getUsersByName(String name) {
        List<User> filteredUsers = new ArrayList<>();
        String query = "SELECT * FROM tbUser WHERE fullname LIKE ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + name + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String fullName = resultSet.getString("fullname");
                    String username = resultSet.getString("username");
                    String roleStr = resultSet.getString("role");
                    UserRole role = UserRole.valueOf(roleStr);  // Assuming UserRole is an enum

                    User user = new User(id, fullName, username, role);
                    filteredUsers.add(user);
                }

                // Check if filteredUsers list is empty
                if (filteredUsers.isEmpty()) {
                    Message.showInfoMessage("No users found with name containing '" + name + "'.");
                    // Alternatively, you can throw an exception or handle the situation based on your application's requirements
                }

            } catch (SQLException e) {
                System.out.println("Error retrieving users by name: " + name);
                e.printStackTrace();  // Handle or log the exception as per your application's requirement
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + query);
            e.printStackTrace();  // Handle or log the exception as per your application's requirement
        }

        return filteredUsers;
    }

    public void updateUser(User users) {
        String selectSQL = "SELECT * FROM tbUser WHERE ID = ?";
        String updateYear1SQL = "UPDATE tbUser SET fullname = ?, username = ?, role = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear1SQL)) {

            // Check if the record exists
            selectStatement.setInt(1, users.getId());

            ResultSet resultSet = selectStatement.executeQuery();

            if (!resultSet.next()) {
                Message.showInfoMessage("No User found for ID: " + users.getId());
                return;
            }

            boolean confirm = Message.showConfirmMessage("Are you sure you want to User the student with ID: " + users.getId() + "?");

            if (!confirm) {
                Message.showInfoMessage("Update cancelled by user.");
                return;
            }

            // Update tbUser
            updateStatement.setString(1, users.getFullName());
            updateStatement.setString(2, users.getUsername());
            updateStatement.setString(3, String.valueOf(users.getRole()));
            updateStatement.setInt(4, users.getId());

            // Logging to check the parameters being set
            System.out.println("Updating user with id: " + users.getId());
            System.out.println("Fullname: " + users.getFullName());
            System.out.println("Username: " + users.getUsername());
            System.out.println("Role: " + users.getRole());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No User updated. User with ID: " + users.getId() + " not found.");
            } else {
                Message.showInfoMessage("Update successful for User with ID: " + users.getId());
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error updating User: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteUser(Integer id) {
        String deleteUser1SQL = "DELETE FROM tbUser WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteUser1SQL)) {

            // Set parameters for the prepared statement
            deleteStatement.setInt(1, id);


            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No User deleted. User with stdCode: " + id + " not found.");
            } else {
                Message.showInfoMessage("Delete successful for user with ID: " + id );
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error deleting User: " + e.getMessage());
            e.printStackTrace();
        }
    }


}

