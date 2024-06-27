package org.example.repository;

import org.example.model.Student;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD FROM tbStudent";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public void addStudent(Student student) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String newStdCode = generateNewStdCode(connection);
            String query = "INSERT INTO tbStudent (stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newStdCode);
            preparedStatement.setString(2, student.getStdName());
            preparedStatement.setString(3, student.getStdSex());
            preparedStatement.setString(4, student.getStdAdd());
            preparedStatement.setString(5, student.getStdGrt());
            preparedStatement.setString(6, student.getStdYear());
            preparedStatement.setInt(7, student.getClassID());
            preparedStatement.setDate(8, java.sql.Date.valueOf(student.getStdBD())); // Assuming stdBD is a String representing a date in yyyy-MM-dd format
            preparedStatement.executeUpdate();
        }
    }

    private String generateNewStdCode(Connection connection) throws SQLException {
        String query = "SELECT stdCode FROM tbStudent WHERE stdCode LIKE 'rupp%' ORDER BY stdCode DESC LIMIT 1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            String lastStdCode = resultSet.getString("stdCode");
            int lastNum = Integer.parseInt(lastStdCode.substring(4)); // Extract the numeric part after "rupp"
            return "rupp" + (lastNum + 1);
        } else {
            return "rupp1"; // If no existing code is found, start with "rupp1"
        }
    }

    public void updateStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "UPDATE tbStudent SET stdCode=?, stdName=?, stdSex=?, stdAdd=?, stdGrt=?, stdYear=?, classID=?, stdBD=? WHERE stdID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, student.getStdCode());
            statement.setString(2, student.getStdName());
            statement.setString(3, student.getStdSex());
            statement.setString(4, student.getStdAdd());
            statement.setString(5, student.getStdGrt());
            statement.setString(6, student.getStdYear());
            statement.setInt(7, student.getClassID());
            statement.setString(8, student.getStdBD());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "DELETE FROM tbStudent WHERE stdID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        }
    }
}
