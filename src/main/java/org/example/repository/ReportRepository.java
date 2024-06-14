package org.example.repository;

import org.example.model.ReportYear1;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// repository
public class ReportRepository {

    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public List<ReportYear1> getAllReportsYear1() {
        List<ReportYear1> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD, p.Fundamantal, p.Math, p.PFC, p.The21, p.History, p.CProgram " +
                    "FROM tbStudent s " +
                    "JOIN PTYear1 p ON s.stdCode = p.stdCode";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                reports.add(new ReportYear1(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("Fundamantal"),
                        resultSet.getInt("Math"),
                        resultSet.getInt("PFC"),
                        resultSet.getInt("The21"),
                        resultSet.getInt("History"),
                        resultSet.getInt("CProgram")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<ReportYear1> searchReports(String name, String classId, String generation, String stdCode) {
        List<ReportYear1> reports = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD, p.Fundamantal, p.Math, p.PFC, p.The21, p.History, p.CProgram " +
                "FROM tbStudent s " +
                "JOIN PTYear1 p ON s.stdCode = p.stdCode " +
                "WHERE 1=1");

        if (name != null && !name.isEmpty()) {
            query.append(" AND s.stdName LIKE ?");
        }
        if (classId != null && !classId.isEmpty()) {
            query.append(" AND s.classID = ?");
        }
        if (generation != null && !generation.isEmpty()) {
            query.append(" AND s.stdYear = ?");
        }
        if (stdCode != null && !stdCode.isEmpty()) {
            query.append(" AND s.stdCode = ?");
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query.toString())) {
            int index = 1;
            if (name != null && !name.isEmpty()) {
                statement.setString(index++, "%" + name + "%");
            }
            if (classId != null && !classId.isEmpty()) {
                statement.setString(index++, classId);
            }
            if (generation != null && !generation.isEmpty()) {
                statement.setString(index++, generation);
            }
            if (stdCode != null && !stdCode.isEmpty()) {
                statement.setString(index++, stdCode);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reports.add(new ReportYear1(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("Fundamantal"),
                        resultSet.getInt("Math"),
                        resultSet.getInt("PFC"),
                        resultSet.getInt("The21"),
                        resultSet.getInt("History"),
                        resultSet.getInt("CProgram")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }
}
