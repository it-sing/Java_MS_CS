package org.example.repository;

import org.example.model.Student;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.Vector;

public class StudentRepository {
    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public StudentRepository() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO tbStudent (stuID, stdCode, stdName, stdSex, birth, stdAdd, stdGrt, stdYear, classId, stdDb) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, student.getStuID());
            preparedStatement.setString(2, student.getStdCode());
            preparedStatement.setString(3, student.getStdName());
            preparedStatement.setString(4, student.getStdSex());
            preparedStatement.setString(5, student.getStdAdd());
            preparedStatement.setString(6, student.getStdGrt());
            preparedStatement.setString(7, student.getStdYear());
            preparedStatement.setString(8, student.getClassId());
            preparedStatement.setString(9, student.getStdDb());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE tbStudent SET stdCode = ?, stdName = ?, stdSex = ?, birth = ?, stdAdd = ?, stdGrt = ?, stdYear = ?, classId = ?, stdDb = ? WHERE stuID = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getStdCode());
            preparedStatement.setString(2, student.getStdName());
            preparedStatement.setString(3, student.getStdSex());
            preparedStatement.setString(4, student.getStdAdd());
            preparedStatement.setString(5, student.getStdGrt());
            preparedStatement.setString(6, student.getStdYear());
            preparedStatement.setString(7, student.getClassId());
            preparedStatement.setString(8, student.getStdDb());
            preparedStatement.setInt(9, student.getStuID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int stuID) {
        String sql = "DELETE FROM tbStudent WHERE stuID = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, stuID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int stuID) {
        Student student = null;
        String sql = "SELECT * FROM tbStudent WHERE stuID = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, stuID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setStuID(resultSet.getInt("stuID"));
                student.setStdCode(resultSet.getString("stdCode"));
                student.setStdName(resultSet.getString("stdName"));
                student.setStdSex(resultSet.getString("stdSex"));
                student.setStdAdd(resultSet.getString("stdAdd"));
                student.setStdGrt(resultSet.getString("stdGrt"));
                student.setStdYear(resultSet.getString("stdYear"));
                student.setClassId(resultSet.getString("classId"));
                student.setStdDb(resultSet.getString("stdDb"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean studentExists(int stuID) {
        String sql = "SELECT 1 FROM tbStudent WHERE stuID = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, stuID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Vector<Vector<Object>> getAllRecords() {
        Vector<Vector<Object>> data = new Vector<>();
        String sql = "SELECT * FROM tbStudent";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<>();
        String sql = "SELECT * FROM tbStudent";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }
}

