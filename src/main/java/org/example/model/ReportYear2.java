package org.example.model;

public class ReportYear2 extends Student{

    private final Integer communication;
    private final Integer dataStructure;
    private final Integer English;
    private final Integer cPlusPlus;
    private final Integer architecture;
    private final Integer database;
    private final String Semester;
    private final Double avg;


    public ReportYear2(String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD, Integer communication, Integer dataStructure, Integer english, Integer cPlusPlus, Integer architecture, Integer database, String semester, Double avg) {
        super(stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD);
        this.communication = communication;
        this.dataStructure = dataStructure;
        English = english;
        this.cPlusPlus = cPlusPlus;
        this.architecture = architecture;
        this.database = database;
        Semester = semester;
        this.avg = avg;
    }

    public Integer getCommunication() {
        return communication;
    }

    public Integer getDataStructure() {
        return dataStructure;
    }

    public Integer getEnglish() {
        return English;
    }

    public Integer getCPlusPlus() {
        return cPlusPlus;
    }

    public Integer getArchitecture() {
        return architecture;
    }

    public Integer getDatabase() {
        return database;
    }

    public String getSemester() {
        return Semester;
    }

    public Double getAvg() {
        return avg;
    }
}
