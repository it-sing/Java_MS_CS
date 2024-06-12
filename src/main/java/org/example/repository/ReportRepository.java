package org.example.repository;

import org.example.model.DataY1;
import org.example.util.PropertyLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository {

    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");
    // for List Student  Year 1

    public List<DataY1> getStudentsY1(String stdCode, String className, String stdGrt, String stdYear) {
        List<DataY1> studentsY1 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, tbStudent.stdYear, ")
                .append("PTYear1.EFC, PTYear1.Fundamantal, PTYear1.Math, PTYear1.PFC, ")
                .append("PTYear1.The21, PTYear1.History, PTYear1.CProgram ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear1 ON tbStudent.stdCode = PTYear1.stdCode WHERE 1=1 ");

        List<Object> parameters = new ArrayList<>();

        if (stdCode != null && !stdCode.isEmpty()) {
            queryBuilder.append("AND tbStudent.stdCode = ? ");
            parameters.add(stdCode);
        }
        if (className != null && !className.isEmpty()) {
            queryBuilder.append("AND tbClass.className = ? ");
            parameters.add(className);
        }
        if (stdGrt != null && !stdGrt.isEmpty()) {
            queryBuilder.append("AND tbStudent.stdGrt = ? ");
            parameters.add(stdGrt);
        }

        if (stdYear != null && !stdYear.isEmpty()) {
            queryBuilder.append("AND tbStudent.stdYear = ? ");
            parameters.add(stdYear);
        }

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                if (parameters.get(i) instanceof Integer) {
                    statement.setInt(i + 1, (Integer) parameters.get(i));
                } else {
                    statement.setString(i + 1, (String) parameters.get(i));
                }
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY1 studentY1 = new DataY1();
                studentY1.setStdYear(resultSet.getString("stdYear"));
                studentY1.setStdCode(resultSet.getString("stdCode"));
                studentY1.setStdName(resultSet.getString("stdName"));
                studentY1.setStdSex(resultSet.getString("stdSex"));
                studentY1.setCProgram(resultSet.getDouble("CProgram"));
                studentY1.setEnglish(resultSet.getDouble("EFC"));
                studentY1.setFundamental(resultSet.getDouble("Fundamantal"));
                studentY1.setMath(resultSet.getDouble("Math"));
                studentY1.setPhysics(resultSet.getDouble("PFC"));
                studentY1.setCenturySkill(resultSet.getDouble("The21"));
                studentY1.setHistory(resultSet.getDouble("History"));

                studentsY1.add(studentY1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentsY1;
    }
}
