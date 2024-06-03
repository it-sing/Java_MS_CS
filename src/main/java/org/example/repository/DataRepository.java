package org.example.repository;

import org.example.model.DataY1;
import org.example.model.DataY2;
import org.example.model.DataY3;
import org.example.model.DataY4;
import org.example.util.PropertyLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");
    // for List Student  Year 1
    public List<DataY1> getStudentsY1(String stdCode, String className, String stdGrt) {
        List<DataY1> studentsY1 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, ")
                .append("PTYear1.EFC, PTYear1.Fundamantal, PTYear1.Math, PTYear1.PFC, ")
                .append("PTYear1.The21, PTYear1.History, PTYear1.CProgram ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear1 ON tbStudent.stdCode = PTYear1.stdCode WHERE 1=1 ");

        List<String> parameters = new ArrayList<>();

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

        // Adding condition for selecting only students in the first year
        queryBuilder.append("AND tbStudent.stdYear = 1 ");

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY1 studentY1 = new DataY1();
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

    // for Update student
    public void updateStudentY1(DataY1 student) {
        String updateYear1SQL = "UPDATE PTYear1 SET EFC = ?, Fundamantal  = ?, Math = ?, PFC = ?, The21 = ?, History = ?, CProgram = ? WHERE stdCode = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear1SQL)) {

            // Update PTYear1
            updateStatement.setDouble(1, student.getEnglish());
            updateStatement.setDouble(2, student.getFundamental());
            updateStatement.setDouble(3, student.getMath());
            updateStatement.setDouble(4, student.getPhysics());
            updateStatement.setDouble(5, student.getCenturySkill());
            updateStatement.setDouble(6, student.getHistory());
            updateStatement.setDouble(7, student.getCProgram());
            updateStatement.setString(8, student.getStdCode()); // Assuming getStdCode returns the student code
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No rows updated. Student with stdCode: " + student.getStdCode() + " not found.");
            } else {
                System.out.println("Update successful for student with stdCode: " + student.getStdCode());
            }

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // for List Student  Year 2
    public List<DataY2> getStudentsY2(String stdCode, String className, String stdGrt) {
        List<DataY2> studentsY2 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, ")
                .append("PTYear2.Communication, PTYear2.DataStructure, PTYear2.English, PTYear2.CPlusPlus, ")
                .append("PTYear2.Architecture, PTYear2.Database ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear2 ON tbStudent.stdCode = PTYear2.stdCode WHERE 1=1 ");

        List<String> parameters = new ArrayList<>();

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
        // Adding condition for selecting only students in the first year
        queryBuilder.append("AND tbStudent.stdYear = 2 ");

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY2 studentY2 = new DataY2();
                studentY2.setStdCode(resultSet.getString("stdCode"));
                studentY2.setStdName(resultSet.getString("stdName"));
                studentY2.setStdSex(resultSet.getString("stdSex"));
                studentY2.setDatabase(resultSet.getDouble("Database"));
                studentY2.setDataStructure(resultSet.getDouble("DataStructure"));
                studentY2.setArchitecture(resultSet.getDouble("Architecture"));
                studentY2.setCommunication(resultSet.getDouble("Communication"));
                studentY2.setCPlusPlus(resultSet.getDouble("CPlusPlus"));
                studentY2.setEEnglish(resultSet.getDouble("English"));

                studentsY2.add(studentY2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentsY2;
    }
//     for Update student
    public void updateStudentY2(DataY2 student) {
        String updateYear1SQL = "UPDATE PTYear2 SET Communication = ?, DataStructure  = ?, English = ?, Cplusplus = ?, Architecture = ?, Database = ? WHERE stdCode = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear1SQL)) {

            // Update PTYear1
            updateStatement.setDouble(1, student.getCommunication());
            updateStatement.setDouble(2, student.getDataStructure());
            updateStatement.setDouble(3, student.getEEnglish());
            updateStatement.setDouble(4, student.getCPlusPlus());
            updateStatement.setDouble(5, student.getArchitecture());
            updateStatement.setDouble(6, student.getDatabase());
            updateStatement.setString(7, student.getStdCode()); // Assuming getStdCode returns the student code
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No rows updated. Student with stdCode: " + student.getStdCode() + " not found.");
            } else {
                System.out.println("Update successful for student with stdCode: " + student.getStdCode());
            }

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // for List Student  Year 3
    public List<DataY3> getStudentsY3(String stdCode, String className, String stdGrt) {
        List<DataY3> studentsY3 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, ")
                .append("PTYear3.Net, PTYear3.Java, PTYear3.Network, PTYear3.SystemAnalysis, PTYear3.Statistics ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear3 ON tbStudent.stdCode = PTYear3.stdCode WHERE 1=1 ");

        List<String> parameters = new ArrayList<>();

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
        // Adding condition for selecting only students in the third year
        queryBuilder.append("AND tbStudent.stdYear = 3 ");

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY3 studentY3 = new DataY3();
                studentY3.setStdCode(resultSet.getString("stdCode"));
                studentY3.setStdName(resultSet.getString("stdName"));
                studentY3.setStdSex(resultSet.getString("stdSex"));
                studentY3.setDotNet(resultSet.getDouble("Net"));
                studentY3.setJava(resultSet.getDouble("Java"));
                studentY3.setNetwork(resultSet.getDouble("Network"));
                studentY3.setAnalysisDesign(resultSet.getDouble("SystemAnalysis"));
                studentY3.setStatistics(resultSet.getDouble("Statistics"));

                studentsY3.add(studentY3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentsY3;
    }
    //     for Update student
    public void updateStudentY3(DataY3 student) {
        String updateYear3SQL = "UPDATE PTYear3 SET Net = ?, Java = ?, Network = ?, SystemAnalysis = ?, Statistics = ? WHERE stdCode = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear3SQL)) {

            // Update PTYear3
            updateStatement.setDouble(1, student.getDotNet());
            updateStatement.setDouble(2, student.getJava());
            updateStatement.setDouble(3, student.getAnalysisDesign());
            updateStatement.setDouble(4, student.getNetwork());
            updateStatement.setDouble(5, student.getStatistics());
            updateStatement.setString(6, student.getStdCode()); // Assuming getStdCode returns the student code
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No rows updated. Student with stdCode: " + student.getStdCode() + " not found.");
            } else {
                System.out.println("Update successful for student with stdCode: " + student.getStdCode());
            }

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<DataY4> getStudentsY4(String stdCode, String className, String stdGrt) {
        List<DataY4> studentsY4 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, ")
                .append("PTYear4.OOAD, PTYear4.Web AS WebDev, PTYear4.Linux, PTYear4.MIS, PTYear4.SE_IT_PM ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear4 ON tbStudent.stdCode = PTYear4.stdCode WHERE 1=1 ");

        List<String> parameters = new ArrayList<>();

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
        // Adding condition for selecting only students in the fourth year
        queryBuilder.append("AND tbStudent.stdYear = 4 ");

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY4 studentY4 = new DataY4();
                studentY4.setStdCode(resultSet.getString("stdCode"));
                studentY4.setStdName(resultSet.getString("stdName"));
                studentY4.setStdSex(resultSet.getString("stdSex"));
                studentY4.setOoAD(resultSet.getDouble("OOAD"));
                studentY4.setWebDev(resultSet.getDouble("WebDev"));
                studentY4.setLinux(resultSet.getDouble("Linux"));
                studentY4.setMis(resultSet.getDouble("MIS"));
                studentY4.setsE_IT_PM(resultSet.getDouble("SE_IT_PM"));

                studentsY4.add(studentY4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentsY4;
    }
    //     for Update student
    public void updateStudentY4(DataY4 student) {
        String updateYear4SQL = "UPDATE PTYear4 SET OOAD = ?, Web = ?, Linux = ?, MIS = ?, SE_IT_PM = ? WHERE stdCode = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear4SQL)) {

            // Update PTYear3
            updateStatement.setDouble(1, student.getOoAD());
            updateStatement.setDouble(2, student.getWebDev());
            updateStatement.setDouble(3, student.getLinux());
            updateStatement.setDouble(4, student.getMis());
            updateStatement.setDouble(5, student.getsE_IT_PM());
            updateStatement.setString(6, student.getStdCode()); // Assuming getStdCode returns the student code
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No rows updated. Student with stdCode: " + student.getStdCode() + " not found.");
            } else {
                System.out.println("Update successful for student with stdCode: " + student.getStdCode());
            }

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }


}