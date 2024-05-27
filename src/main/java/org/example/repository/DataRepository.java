package org.example.repository;

import org.example.util.PropertyLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRepository {

    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");
    public ResultSet getStudentData(int stdID) {
        String query = "SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, " +
                "PTYear1.EFC, PTYear1.Fundamantal, PTYear1.Math, PTYear1.PFC, " +
                "PTYear1.The21, PTYear1.HIstory, PTYear1.CProgram " +
                "FROM tbStudent " +
                "INNER JOIN PTYear1 ON tbStudent.stdID = PTYear1.stdID " +
                "WHERE tbStudent.stdID = ?";
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stdID);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
