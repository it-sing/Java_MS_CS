package org.example.repository;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String DATABASE_URL = "jdbc:ucanaccess://D:/9. RUPP/Year3/Java E7/ManagementPointStudent.accdb";

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

    public void addStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "INSERT INTO tbStudent (stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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

    public void deleteStudent(int stdID) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "DELETE FROM tbStudent WHERE stdID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, stdID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
