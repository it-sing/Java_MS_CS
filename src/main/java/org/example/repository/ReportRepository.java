package org.example.repository;

import org.example.model.Report;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository {

    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    public List<Report> getAllReportsYear1() {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD, p.Fundamantal, p.Math, p.PFC, p.The21, p.History, p.CProgram " +
                    "FROM tbStudent s " +
                    "JOIN PTYear1 p ON s.stdCode = p.stdCode";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                reports.add(new Report(
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

    public List<Report> searchReportsByNameYear1(List<String> names) {
        List<Report> reports = new ArrayList<>();
        if (names == null || names.isEmpty()) {
            return reports;
        }

        StringBuilder query = new StringBuilder("SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD, p.Fundamantal, p.Math, p.PFC, p.The21, p.History, p.CProgram " +
                "FROM tbStudent s " +
                "JOIN PTYear1 p ON s.stdCode = p.stdCode " +
                "WHERE ");
        for (int i = 0; i < names.size(); i++) {
            query.append("s.stdName LIKE ?");
            if (i < names.size() - 1) {
                query.append(" OR ");
            }
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < names.size(); i++) {
                statement.setString(i + 1, "%" + names.get(i) + "%");
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reports.add(new Report(
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
