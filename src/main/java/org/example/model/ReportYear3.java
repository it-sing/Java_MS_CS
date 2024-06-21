package org.example.model;

public class ReportYear3 {
    private Integer stdID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private Integer classID;
    private String stdBD;
    private Integer dotNet;
    private Integer Java;
    private Integer network;
    private Integer isad;
    private Integer statistics;
    private String Semester;
    private Double avg;

    public ReportYear3(Integer stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, Integer classID, String stdBD, Integer dotNet, Integer java, Integer network, Integer isad, Integer statistics, String semester, Double avg) {
        this.stdID = stdID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
        this.dotNet = dotNet;
        this.Java = java;
        this.network = network;
        this.isad = isad;
        this.statistics = statistics;
        this.Semester = semester;
        this.avg = avg;
    }

    public Integer getStdID() {
        return stdID;
    }

    public String getStdCode() {
        return stdCode;
    }

    public String getStdName() {
        return stdName;
    }

    public String getStdSex() {
        return stdSex;
    }

    public String getStdAdd() {
        return stdAdd;
    }

    public String getStdGrt() {
        return stdGrt;
    }

    public String getStdYear() {
        return stdYear;
    }

    public Integer getClassID() {
        return classID;
    }

    public String getStdBD() {
        return stdBD;
    }

    public Integer getDotNet() {
        return dotNet;
    }

    public Integer getJava() {
        return Java;
    }

    public Integer getNetwork() {
        return network;
    }

    public Integer getIsad() {
        return isad;
    }

    public Integer getStatistics() {
        return statistics;
    }

    public String getSemester() {
        return Semester;
    }

    public Double getAvg() {
        return avg;
    }
}
