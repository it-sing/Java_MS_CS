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
            String query = "SELECT * FROM tbStudent";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("stdID"),
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
            String query = "INSERT INTO tbStudent (stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStdCode());
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
            statement.setInt(9, student.getStdID());
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
