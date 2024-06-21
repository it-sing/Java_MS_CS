package org.example.model;

public class ReportYear4 {
    private Integer stdID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private Integer classID;
    private String stdBD;
    private Integer ooad;
    private Integer web;
    private Integer linux;
    private Integer mis;
    private Integer se;
    private String Semester;
    private Double avg;

    public ReportYear4(Integer stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, Integer classID, String stdBD, Integer ooad, Integer web, Integer linux, Integer mis, Integer se, String semester, Double avg) {
        this.stdID = stdID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
        this.ooad = ooad;
        this.web = web;
        this.linux = linux;
        this.mis = mis;
        this.se = se;
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

    public Integer getOoad() {
        return ooad;
    }

    public Integer getWeb() {
        return web;
    }

    public Integer getLinux() {
        return linux;
    }

    public Integer getMis() {
        return mis;
    }

    public Integer getSe() {
        return se;
    }

    public String getSemester() {
        return Semester;
    }

    public Double getAvg() {
        return avg;
    }
}
