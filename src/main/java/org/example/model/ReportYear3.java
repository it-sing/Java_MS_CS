package org.example.model;

public class ReportYear3 extends Student{

    private final Integer dotNet;
    private final Integer Java;
    private final Integer network;
    private final Integer iSad;
    private final Integer statistics;
    private final String Semester;
    private final Double avg;

    public ReportYear3(String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD, Integer dotNet, Integer java, Integer network, Integer iSad, Integer statistics, String semester, Double avg) {
        super(stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD);
        this.dotNet = dotNet;
        Java = java;
        this.network = network;
        this.iSad = iSad;
        this.statistics = statistics;
        Semester = semester;
        this.avg = avg;
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

    public Integer getISad() {
        return iSad;
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
