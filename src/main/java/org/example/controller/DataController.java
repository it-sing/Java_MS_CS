package org.example.controller;

import org.example.repository.DataRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataController {

    private DataRepository dataRepository;

    public DataController() {
        this.dataRepository = new DataRepository();
    }

    public void printStudentData(int stdID) {
        ResultSet resultSet = dataRepository.getStudentData(stdID);
        try {
            while (resultSet.next()) {
                String stdCode = resultSet.getString("stdCode");
                String stdName = resultSet.getString("stdName");
                String stdSex = resultSet.getString("stdSex");
                int efc = resultSet.getInt("EFC");
                int fundamental = resultSet.getInt("Fundamantal");
                int math = resultSet.getInt("Math");
                int pfc = resultSet.getInt("PFC");
                int the21 = resultSet.getInt("The21");
                int history = resultSet.getInt("HIstory");
                int cProgram = resultSet.getInt("CProgram");

                System.out.println("Student Code: " + stdCode);
                System.out.println("Student Name: " + stdName);
                System.out.println("Student Sex: " + stdSex);
                System.out.println("EFC: " + efc);
                System.out.println("Fundamental: " + fundamental);
                System.out.println("Math: " + math);
                System.out.println("PFC: " + pfc);
                System.out.println("The 21: " + the21);
                System.out.println("History: " + history);
                System.out.println("C Program: " + cProgram);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
