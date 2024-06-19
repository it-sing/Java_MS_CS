package org.example.repository;

import org.example.model.ReportYear1;
import org.example.model.ReportYear2;
import org.example.model.ReportYear3;
import org.example.model.ReportYear4;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// repository
public class ReportRepository {

    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");

    // year1
    public List<ReportYear1> getAllReportsYear1() {
        List<ReportYear1> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                    " p.EFC, p.Fundamantal, p.Math, p.PFC, p.The21, p.History, p.CProgram, p.Semester, " +
                    " ((p.EFC + p.Fundamantal + p.Math + p.PFC + p.The21 + p.History + p.CProgram) / 6) AS AVG " +
                    " FROM tbStudent s " +
                    " JOIN PTYear1 p ON s.stdCode = p.stdCode";
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
                        resultSet.getInt("EFC"),
                        resultSet.getInt("Fundamantal"),
                        resultSet.getInt("Math"),
                        resultSet.getInt("PFC"),
                        resultSet.getInt("The21"),
                        resultSet.getInt("History"),
                        resultSet.getInt("CProgram"),
                        resultSet.getString("Semester"),
                        resultSet.getDouble("AVG")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<ReportYear1> searchReportsYear1(String name, String classId, String generation, String stdCode, String semester) {
        List<ReportYear1> reports = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                " p.EFC, p.Fundamantal, p.Math, p.PFC, p.The21, p.History, p.CProgram, p.Semester, " +
                " ((p.EFC + p.Fundamantal + p.Math + p.PFC + p.The21 + p.History + p.CProgram) / 6) AS AVG " +
                " FROM tbStudent s " +
                " JOIN PTYear1 p ON s.stdCode = p.stdCode " +
                " WHERE 1=1");

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
        if (semester != null && !semester.isEmpty()) {
            query.append(" AND p.Semester = ?");
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
            if (semester != null && !semester.isEmpty()) {
                statement.setString(index++, semester);
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
                        resultSet.getInt("EFC"),
                        resultSet.getInt("Fundamantal"),
                        resultSet.getInt("Math"),
                        resultSet.getInt("PFC"),
                        resultSet.getInt("The21"),
                        resultSet.getInt("History"),
                        resultSet.getInt("CProgram"),
                        resultSet.getString("Semester"),
                        resultSet.getDouble("AVG")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }


    // year2
    public List<ReportYear2> getAllReportsYear2() {
        List<ReportYear2> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                    " p.Communication, p.DataStructure, p.English, p.CPlusPlus, p.Architecture, p.Database, p.Semester " +
                    "FROM tbStudent s " +
                    "JOIN PTYear2 p ON s.stdCode = p.stdCode";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                reports.add(new ReportYear2(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("Communication"),
                        resultSet.getInt("DataStructure"),
                        resultSet.getInt("English"),
                        resultSet.getInt("CPlusPlus"),
                        resultSet.getInt("Architecture"),
                        resultSet.getInt("Database"),
                        resultSet.getString("Semester")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<ReportYear2> searchReportsYear2(String name, String classId, String generation, String stdCode, String semester) {
        List<ReportYear2> reports = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                " p.Communication, p.DataStructure, p.English, p.CPlusPlus, p.Architecture, p.Database, p.Semester " +
                "FROM tbStudent s " +
                "JOIN PTYear2 p ON s.stdCode = p.stdCode " +
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
        if (semester != null && !semester.isEmpty()) {
            query.append(" AND p.Semester = ?");
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
            if (semester != null && !semester.isEmpty()) {
                statement.setString(index++, semester);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reports.add(new ReportYear2(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("Communication"),
                        resultSet.getInt("DataStructure"),
                        resultSet.getInt("English"),
                        resultSet.getInt("CPlusPlus"),
                        resultSet.getInt("Architecture"),
                        resultSet.getInt("Database"),
                        resultSet.getString("Semester")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    // year3
    public List<ReportYear3> getAllReportsYear3() {
        List<ReportYear3> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                    " p.Net, p.Java, p.Network, p.SystemAnalysis, p.Statistics, p.Semester " +
                    "FROM tbStudent s " +
                    "JOIN PTYear3 p ON s.stdCode = p.stdCode";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                reports.add(new ReportYear3(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("Net"),
                        resultSet.getInt("Java"),
                        resultSet.getInt("NetWork"),
                        resultSet.getInt("SystemAnalysis"),
                        resultSet.getInt("Statistics"),
                        resultSet.getString("Semester")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<ReportYear3> searchReportsYear3(String name, String classId, String generation, String stdCode, String semester) {
        List<ReportYear3> reports = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                " p.Net, p.Java, p.Network, p.SystemAnalysis, p.Statistics, p.Semester " +
                "FROM tbStudent s " +
                "JOIN PTYear3 p ON s.stdCode = p.stdCode " +
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
        if (semester != null && !semester.isEmpty()) {
            query.append(" AND p.Semester = ?");
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
            if (semester != null && !semester.isEmpty()) {
                statement.setString(index++, semester);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reports.add(new ReportYear3(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("Net"),
                        resultSet.getInt("Java"),
                        resultSet.getInt("NetWork"),
                        resultSet.getInt("SystemAnalysis"),
                        resultSet.getInt("Statistics"),
                        resultSet.getString("Semester")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    // year3
    public List<ReportYear4> getAllReportsYear4() {
        List<ReportYear4> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                    " p.OOAD, p.Web, p.Linux, p.MIS, p.SE_IT_PM, p.Semester " +
                    "FROM tbStudent s " +
                    "JOIN PTYear4 p ON s.stdCode = p.stdCode";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                reports.add(new ReportYear4(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("OOAD"),
                        resultSet.getInt("Web"),
                        resultSet.getInt("Linux"),
                        resultSet.getInt("MIS"),
                        resultSet.getInt("SE_IT_PM"),
                        resultSet.getString("Semester")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public List<ReportYear4> searchReportsYear4(String name, String classId, String generation, String stdCode, String semester) {
        List<ReportYear4> reports = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT s.stdID, s.stdCode, s.stdName, s.stdSex, s.stdAdd, s.stdGrt, s.stdYear, s.classID, s.stdBD," +
                " p.OOAD, p.Web, p.Linux, p.MIS, p.SE_IT_PM, p.Semester " +
                "FROM tbStudent s " +
                "JOIN PTYear4 p ON s.stdCode = p.stdCode " +
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
        if (semester != null && !semester.isEmpty()) {
            query.append(" AND p.Semester = ?");
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
            if (semester != null && !semester.isEmpty()) {
                statement.setString(index++, semester);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reports.add(new ReportYear4(
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD").toString(),
                        resultSet.getInt("OOAD"),
                        resultSet.getInt("Web"),
                        resultSet.getInt("Linux"),
                        resultSet.getInt("MIS"),
                        resultSet.getInt("SE_IT_PM"),
                        resultSet.getString("Semester")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }


}
