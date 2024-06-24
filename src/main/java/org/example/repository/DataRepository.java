package org.example.repository;

import org.example.model.DataY1;
import org.example.model.DataY2;
import org.example.model.DataY3;
import org.example.model.DataY4;
import org.example.util.Message;
import org.example.util.PropertyLoader;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private static final String DATABASE_URL = PropertyLoader.getProperty("database.url");
    // for List Student  Year 1
    public List<DataY1> getStudentsY1(String stdCode, String className, String stdGrt, String stdName, String semester) {
        List<DataY1> studentsY1 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, tbStudent.stdYear, ")
                .append("PTYear1.EFC, PTYear1.Fundamental, PTYear1.Math, PTYear1.PFC, ")
                .append("PTYear1.The21, PTYear1.History, PTYear1.CProgram, PTYear1.Semester ")
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

        if (stdName != null && !stdName.isEmpty()) {
            queryBuilder.append(" AND tbStudent.stdName LIKE ?");
            parameters.add("%" + stdName + "%");
        }

        if (semester != null && !semester.isEmpty()) {
            queryBuilder.append("AND Semester = ? ");
            parameters.add(semester);
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
                studentY1.setSemester(resultSet.getString("Semester"));
                studentY1.setCProgram(resultSet.getDouble("CProgram"));
                studentY1.setEnglish(resultSet.getDouble("EFC"));
                studentY1.setFundamental(resultSet.getDouble("Fundamental"));
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

    public void updateStudentY1(DataY1 student) {
        String selectSQL = "SELECT COUNT(*) FROM PTYear1 WHERE stdCode = ? AND Semester = ?";
        String updateYear1SQL = "UPDATE PTYear1 SET EFC = ?, Fundamental = ?, Math = ?, PFC = ?, The21 = ?, History = ?, CProgram = ? WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear1SQL)) {

            // Check if the record exists
            selectStatement.setString(1, student.getStdCode());
            selectStatement.setString(2, student.getSemester());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    Message.showInfoMessage("No Student found for stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
                    return;
                }
            }

            boolean confirm = Message.showConfirmMessage("Are you sure you want to update the student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + "?");

            if (!confirm) {
                Message.showInfoMessage("Update cancelled by user.");
                return;
            }

            // Update PTYear1
            updateStatement.setDouble(1, student.getEnglish());
            updateStatement.setDouble(2, student.getFundamental());
            updateStatement.setDouble(3, student.getMath());
            updateStatement.setDouble(4, student.getPhysics());
            updateStatement.setDouble(5, student.getCenturySkill());
            updateStatement.setDouble(6, student.getHistory());
            updateStatement.setDouble(7, student.getCProgram());
            updateStatement.setString(8, student.getStdCode());
            updateStatement.setString(9, student.getSemester());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student updated. Student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + " not found.");
            } else {
                Message.showInfoMessage("Update successful for student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertStudentY1(DataY1 student) {
        String checkStdCodeSQL = "SELECT COUNT(*) FROM PTYear1 WHERE stdCode = ? AND Semester = ?";
        String insertYear1SQL = "INSERT INTO PTYear1 (EFC, Fundamental, Math, PFC, The21, History, CProgram, stdCode, Semester ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement checkStatement = connection.prepareStatement(checkStdCodeSQL);
             PreparedStatement insertStatement = connection.prepareStatement(insertYear1SQL)) {

            // Set parameters for the check statement
            checkStatement.setString(1, student.getStdCode());
            checkStatement.setString(2, student.getSemester());

            // Execute the check statement
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();  // Move to the first row
            int count = resultSet.getInt(1);

            if (count > 0) {
                Message.showInfoMessage("Student with stdCode " + student.getStdCode() + " already has a record for semester " + student.getSemester() + ".");
            } else {
                // Set parameters for the insert statement
                insertStatement.setDouble(1, student.getEnglish());
                insertStatement.setDouble(2, student.getFundamental());
                insertStatement.setDouble(3, student.getMath());
                insertStatement.setDouble(4, student.getPhysics());
                insertStatement.setDouble(5, student.getCenturySkill());
                insertStatement.setDouble(6, student.getHistory());
                insertStatement.setDouble(7, student.getCProgram());
                insertStatement.setString(8, student.getStdCode());
                insertStatement.setString(9, student.getSemester());

                // Execute the insert statement
                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected == 0) {
                    Message.showInfoMessage("No rows inserted for student with stdCode: " + student.getStdCode());
                } else {
                    Message.showInfoMessage("Save successful for student with stdCode: " + student.getStdCode() + " for semester: " + student.getSemester());
                }
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error inserting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteStudentY1(String stdCode, String semester) {
        String deleteYear1SQL = "DELETE FROM PTYear1 WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteYear1SQL)) {

            // Set parameters for the prepared statement
            deleteStatement.setString(1, stdCode);
            deleteStatement.setString(2, semester);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student deleted. Student with stdCode: " + stdCode + " and Semester: " + semester + " not found.");
            } else {
                Message.showInfoMessage("Delete successful for student with stdCode: " + stdCode + " and Semester: " + semester);
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // for List Student  Year 2
    public List<DataY2> getStudentsY2(String stdCode, String className, String stdGrt, String stdName, String semester) {
        List<DataY2> studentsY2 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, tbStudent.stdYear, ")
                .append("PTYear2.Communication, PTYear2.DataStructure, PTYear2.English, PTYear2.CPlusPlus, ")
                .append("PTYear2.Architecture, PTYear2.Database, PTYear2.Semester ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear2 ON tbStudent.stdCode = PTYear2.stdCode ")
                .append("WHERE 1=1 ");

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
        if (stdName != null && !stdName.isEmpty()) {
            queryBuilder.append(" AND tbStudent.stdName LIKE ?");
            parameters.add("%" + stdName + "%");
        }
        if (semester != null && !semester.isEmpty()) {
            queryBuilder.append("AND Semester = ? ");
            parameters.add(semester);
        }

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY2 studentY2 = new DataY2();
                studentY2.setStdYear(resultSet.getString("stdYear"));
                studentY2.setStdCode(resultSet.getString("stdCode"));
                studentY2.setStdName(resultSet.getString("stdName"));
                studentY2.setStdSex(resultSet.getString("stdSex"));
                studentY2.setSemester(resultSet.getString("Semester"));
                studentY2.setDataStructure(resultSet.getDouble("DataStructure"));
                studentY2.setArchitecture(resultSet.getDouble("Architecture"));
                studentY2.setCommunication(resultSet.getDouble("Communication"));
                studentY2.setCPlusPlus(resultSet.getDouble("CPlusPlus"));
                studentY2.setEEnglish(resultSet.getDouble("English"));
                studentY2.setDatabase(resultSet.getDouble("Database"));

                studentsY2.add(studentY2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentsY2;
    }
    public void updateStudentY2(DataY2 student) {
        String selectSQL = "SELECT COUNT(*) FROM PTYear2 WHERE stdCode = ? AND Semester = ?";
        String updateYear2SQL = "UPDATE PTYear2 SET Communication = ?, DataStructure = ?, English = ?, CPlusPlus = ?, Architecture = ?, Database = ? WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear2SQL)) {

            // Check if the record exists
            selectStatement.setString(1, student.getStdCode());
            selectStatement.setString(2, student.getSemester());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    Message.showInfoMessage("No Student found for stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
                    return;
                }
            }

            // Show confirmation message
            boolean confirm = Message.showConfirmMessage("Are you sure you want to update the student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + "?");

            if (!confirm) {
                Message.showInfoMessage("Update cancelled by user.");
                return;
            }

            // Update PTYear2
            updateStatement.setDouble(1, student.getCommunication());
            updateStatement.setDouble(2, student.getDataStructure());
            updateStatement.setDouble(3, student.getEEnglish());
            updateStatement.setDouble(4, student.getCPlusPlus());
            updateStatement.setDouble(5, student.getArchitecture());
            updateStatement.setDouble(6, student.getDatabase());
            updateStatement.setString(7, student.getStdCode());
            updateStatement.setString(8, student.getSemester());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student updated. Student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + " not found.");
            } else {
                Message.showInfoMessage("Update successful for student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertStudentY2(DataY2 student) {
        String checkStdCodeSQL = "SELECT COUNT(*) FROM PTYear2 WHERE stdCode = ? AND Semester = ?";
        String insertYear2SQL = "INSERT INTO PTYear2 (stdCode, Communication, DataStructure, English, CPlusPlus, Architecture, Database, Semester) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement checkStatement = connection.prepareStatement(checkStdCodeSQL);
             PreparedStatement insertStatement = connection.prepareStatement(insertYear2SQL)) {

            // Set parameters for the check statement
            checkStatement.setString(1, student.getStdCode());
            checkStatement.setString(2, student.getSemester());

            // Execute the check statement
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();  // Move to the first row
            int count = resultSet.getInt(1);

            if (count > 0) {
                Message.showInfoMessage("Student with stdCode " + student.getStdCode() + " already has a record for semester " + student.getSemester() + ".");
            } else {
                // Set parameters for the insert statement
                insertStatement.setString(1, student.getStdCode());
                insertStatement.setDouble(2, student.getCommunication());
                insertStatement.setDouble(3, student.getDataStructure());
                insertStatement.setDouble(4, student.getEEnglish());
                insertStatement.setDouble(5, student.getCPlusPlus());
                insertStatement.setDouble(6, student.getArchitecture());
                insertStatement.setDouble(7, student.getDatabase());
                insertStatement.setString(8, student.getSemester());

                // Execute the insert statement
                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected == 0) {
                    Message.showInfoMessage("No rows inserted for student with stdCode: " + student.getStdCode());
                } else {
                    Message.showInfoMessage("Save successful for student with stdCode: " + student.getStdCode() + " for semester: " + student.getSemester());
                }
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error inserting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteStudentY2(String stdCode, String semester) {
        String deleteYear2SQL = "DELETE FROM PTYear2 WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteYear2SQL)) {

            // Set parameters for the prepared statement
            deleteStatement.setString(1, stdCode);
            deleteStatement.setString(2, semester);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student deleted. Student with stdCode: " + stdCode + " and Semester: " + semester + " not found.");
            } else {
                Message.showInfoMessage("Delete successful for student with stdCode: " + stdCode + " and Semester: " + semester);
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // for List Student  Year 3
    public List<DataY3> getStudentsY3(String stdCode, String className, String stdGrt, String stdName, String semester) {
        List<DataY3> studentsY3 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, tbStudent.stdYear, ")
                .append("PTYear3.Net, PTYear3.Java, PTYear3.SystemAnalysis, PTYear3.Statistics, PTYear3.Network, PTYear3.Semester ")
                .append("FROM tbStudent ")
                .append("LEFT JOIN tbClass ON tbStudent.classID = tbClass.classID ")
                .append("LEFT JOIN PTYear3 ON tbStudent.stdCode = PTYear3.stdCode ")
                .append("WHERE 1=1 ");

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
        if (stdName != null && !stdName.isEmpty()) {
            queryBuilder.append(" AND tbStudent.stdName LIKE ?");
            parameters.add("%" + stdName + "%");
        }
        if (semester != null && !semester.isEmpty()) {
            queryBuilder.append("AND PTYear3.Semester = ? ");
            parameters.add(semester);
        }

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY3 studentY3 = new DataY3();
                studentY3.setStdYear(resultSet.getString("stdYear"));
                studentY3.setStdCode(resultSet.getString("stdCode"));
                studentY3.setStdName(resultSet.getString("stdName"));
                studentY3.setStdSex(resultSet.getString("stdSex"));
                studentY3.setSemester(resultSet.getString("Semester"));
                studentY3.setDotNet(resultSet.getDouble("Net"));
                studentY3.setJava(resultSet.getDouble("Java"));
                studentY3.setAnalysisDesign(resultSet.getDouble("SystemAnalysis"));
                studentY3.setStatistics(resultSet.getDouble("Statistics"));
                studentY3.setNetwork(resultSet.getDouble("Network"));

                studentsY3.add(studentY3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentsY3;
    }
    public void updateStudentY3(DataY3 student) {
        String selectSQL = "SELECT COUNT(*) FROM PTYear3 WHERE stdCode = ? AND Semester = ?";
        String updateYear3SQL = "UPDATE PTYear3 SET Net = ?, Java = ?, Network = ?, SystemAnalysis = ?, Statistics = ? WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear3SQL)) {

            // Check if the record exists
            selectStatement.setString(1, student.getStdCode());
            selectStatement.setString(2, student.getSemester());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    Message.showInfoMessage("No Student found for stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
                    return;
                }
            }

            // Show confirmation message
            boolean confirm = Message.showConfirmMessage("Are you sure you want to update the student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + "?");

            if (!confirm) {
                Message.showInfoMessage("Update cancelled by user.");
                return;
            }

            // Update PTYear3
            updateStatement.setDouble(1, student.getDotNet());
            updateStatement.setDouble(2, student.getJava());
            updateStatement.setDouble(3, student.getNetwork());
            updateStatement.setDouble(4, student.getAnalysisDesign());
            updateStatement.setDouble(5, student.getStatistics());
            updateStatement.setString(6, student.getStdCode());
            updateStatement.setString(7, student.getSemester());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student updated. Student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + " not found.");
            } else {
                Message.showInfoMessage("Update successful for student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertStudentY3(DataY3 student) {
        String checkStdCodeSQL = "SELECT COUNT(*) FROM PTYear3 WHERE stdCode = ? AND Semester = ?";
        String insertYear3SQL = "INSERT INTO PTYear3 (stdCode, Net, Java, SystemAnalysis, Statistics,  Network, Semester) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement checkStatement = connection.prepareStatement(checkStdCodeSQL);
             PreparedStatement insertStatement = connection.prepareStatement(insertYear3SQL)) {

            // Set parameters for the check statement
            checkStatement.setString(1, student.getStdCode());
            checkStatement.setString(2, student.getSemester());

            // Execute the check statement
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();  // Move to the first row
            int count = resultSet.getInt(1);

            if (count > 0) {
                Message.showInfoMessage("Student with stdCode " + student.getStdCode() + " already has a record for semester " + student.getSemester() + ".");
            } else {
                // Set parameters for the insert statement
                insertStatement.setString(1, student.getStdCode());
                insertStatement.setDouble(2, student.getDotNet());
                insertStatement.setDouble(3, student.getJava());
                insertStatement.setDouble(4, student.getNetwork());
                insertStatement.setDouble(5, student.getAnalysisDesign());
                insertStatement.setDouble(6, student.getStatistics());
                insertStatement.setString(7, student.getSemester());

                // Execute the insert statement
                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected == 0) {
                    Message.showInfoMessage("No rows inserted for student with stdCode: " + student.getStdCode());
                } else {
                    Message.showInfoMessage("Save successful for student with stdCode: " + student.getStdCode() + " for semester: " + student.getSemester());
                }
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error inserting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteStudentY3(String stdCode, String semester) {
        String deleteYear3SQL = "DELETE FROM PTYear3 WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteYear3SQL)) {

            // Set parameters for the prepared statement
            deleteStatement.setString(1, stdCode);
            deleteStatement.setString(2, semester);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student deleted. Student with stdCode: " + stdCode + " and Semester: " + semester + " not found.");
            } else {
                Message.showInfoMessage("Delete successful for student with stdCode: " + stdCode + " and Semester: " + semester);
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<DataY4> getStudentsY4(String stdCode, String className, String stdGrt, String stdName, String semester) {
        List<DataY4> studentsY4 = new ArrayList<>();

        StringBuilder queryBuilder = new StringBuilder("SELECT tbStudent.stdCode, tbStudent.stdName, tbStudent.stdSex, tbStudent.stdYear, ")
                .append("PTYear4.OOAD, PTYear4.Web AS WebDev, PTYear4.Linux, PTYear4.MIS, PTYear4.SE_IT_PM, PTYear4.Semester ")
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
        if (stdName != null && !stdName.isEmpty()) {
            queryBuilder.append(" AND tbStudent.stdName LIKE ?");
            parameters.add("%" + stdName + "%");
        }
        if (semester != null && !semester.isEmpty()) {
            queryBuilder.append("AND PTYear4.Semester = ? ");
            parameters.add(semester);
        }

        String query = queryBuilder.toString();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.size(); i++) {
                statement.setString(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DataY4 studentY4 = new DataY4();
                studentY4.setStdYear(resultSet.getString("stdYear"));
                studentY4.setStdCode(resultSet.getString("stdCode"));
                studentY4.setStdName(resultSet.getString("stdName"));
                studentY4.setStdSex(resultSet.getString("stdSex"));
                studentY4.setSemester(resultSet.getString("Semester"));
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
    public void updateStudentY4(DataY4 student) {
        String selectSQL = "SELECT COUNT(*) FROM PTYear4 WHERE stdCode = ? AND Semester = ?";
        String updateYear4SQL = "UPDATE PTYear4 SET OOAD = ?, Web = ?, Linux = ?, MIS = ?, SE_IT_PM = ? WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
             PreparedStatement updateStatement = connection.prepareStatement(updateYear4SQL)) {

            // Check if the record exists
            selectStatement.setString(1, student.getStdCode());
            selectStatement.setString(2, student.getSemester());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    Message.showInfoMessage("No Student found for stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
                    return;
                }
            }

            // Show confirmation message
            boolean confirm = Message.showConfirmMessage("Are you sure you want to update the student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + "?");

            if (!confirm) {
                Message.showInfoMessage("Update cancelled by user.");
                return;
            }

            // Update PTYear4
            updateStatement.setDouble(1, student.getOoAD());
            updateStatement.setDouble(2, student.getWebDev());
            updateStatement.setDouble(3, student.getLinux());
            updateStatement.setDouble(4, student.getMis());
            updateStatement.setDouble(5, student.getsE_IT_PM());
            updateStatement.setString(6, student.getStdCode());
            updateStatement.setString(7, student.getSemester());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student updated. Student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester() + " not found.");
            } else {
                Message.showInfoMessage("Update successful for student with stdCode: " + student.getStdCode() + " and Semester: " + student.getSemester());
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertStudentY4(DataY4 student) {
        String checkStdCodeSQL = "SELECT COUNT(*) FROM PTYear4 WHERE stdCode = ? AND Semester = ?";
        String insertYear4SQL = "INSERT INTO PTYear4 (stdCode, OOAD, Web, Linux, MIS, SE_IT_PM, Semester) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement checkStatement = connection.prepareStatement(checkStdCodeSQL);
             PreparedStatement insertStatement = connection.prepareStatement(insertYear4SQL)) {

            // Set parameters for the check statement
            checkStatement.setString(1, student.getStdCode());
            checkStatement.setString(2, student.getSemester());

            // Execute the check statement
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();  // Move to the first row
            int count = resultSet.getInt(1);

            if (count > 0) {
                Message.showInfoMessage("Student with stdCode " + student.getStdCode() + " already has a record for semester " + student.getSemester() + ".");
            } else {
                // Set parameters for the insert statement
                insertStatement.setString(1, student.getStdCode());
                insertStatement.setDouble(2, student.getOoAD());
                insertStatement.setDouble(3, student.getWebDev());
                insertStatement.setDouble(4, student.getLinux());
                insertStatement.setDouble(5, student.getMis());
                insertStatement.setDouble(6, student.getsE_IT_PM());
                insertStatement.setString(7, student.getSemester());

                // Execute the insert statement
                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected == 0) {
                    Message.showInfoMessage("No rows inserted for student with stdCode: " + student.getStdCode());
                } else {
                    Message.showInfoMessage("Save successful for student with stdCode: " + student.getStdCode() + " for semester: " + student.getSemester());
                }
            }
        } catch (SQLException e) {
            Message.showErrorMessage("Error inserting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteStudentY4(String stdCode, String semester) {
        String deleteYear4SQL = "DELETE FROM PTYear4 WHERE stdCode = ? AND Semester = ?";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteYear4SQL)) {

            // Set parameters for the prepared statement
            deleteStatement.setString(1, stdCode);
            deleteStatement.setString(2, semester);

            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected == 0) {
                Message.showInfoMessage("No Student deleted. Student with stdCode: " + stdCode + " and Semester: " + semester + " not found.");
            } else {
                Message.showInfoMessage("Delete successful for student with stdCode: " + stdCode + " and Semester: " + semester);
            }

        } catch (SQLException e) {
            Message.showErrorMessage("Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

}