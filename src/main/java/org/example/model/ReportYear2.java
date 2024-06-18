package org.example.model;

public class ReportYear2 {
    private Integer stdID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private Integer classID;
    private String stdBD;
    private Integer communication;
    private Integer dataStructure;
    private Integer English;
    private Integer cPlusPlus;
    private Integer architecture;
    private Integer database;
    private String Semester;

    public ReportYear2(Integer stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, Integer classID, String stdBD, Integer communication, Integer dataStructure, Integer english, Integer cPlusPlus, Integer architecture, Integer database, String semester) {
        this.stdID = stdID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
        this.communication = communication;
        this.dataStructure = dataStructure;
        English = english;
        this.cPlusPlus = cPlusPlus;
        this.architecture = architecture;
        this.database = database;
        Semester = semester;
    }

    public Integer getStdID() {
        return stdID;
    }

    public void setStdID(Integer stdID) {
        this.stdID = stdID;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdSex() {
        return stdSex;
    }

    public void setStdSex(String stdSex) {
        this.stdSex = stdSex;
    }

    public String getStdAdd() {
        return stdAdd;
    }

    public void setStdAdd(String stdAdd) {
        this.stdAdd = stdAdd;
    }

    public String getStdGrt() {
        return stdGrt;
    }

    public void setStdGrt(String stdGrt) {
        this.stdGrt = stdGrt;
    }

    public String getStdYear() {
        return stdYear;
    }

    public void setStdYear(String stdYear) {
        this.stdYear = stdYear;
    }

    public Integer getClassID() {
        return classID;
    }

    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public String getStdBD() {
        return stdBD;
    }

    public void setStdBD(String stdBD) {
        this.stdBD = stdBD;
    }

    public Integer getCommunication() {
        return communication;
    }

    public void setCommunication(Integer communication) {
        this.communication = communication;
    }

    public Integer getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(Integer dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Integer getEnglish() {
        return English;
    }

    public void setEnglish(Integer english) {
        English = english;
    }

    public Integer getcPlusPlus() {
        return cPlusPlus;
    }

    public void setcPlusPlus(Integer cPlusPlus) {
        this.cPlusPlus = cPlusPlus;
    }

    public Integer getArchitecture() {
        return architecture;
    }

    public void setArchitecture(Integer architecture) {
        this.architecture = architecture;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
}
