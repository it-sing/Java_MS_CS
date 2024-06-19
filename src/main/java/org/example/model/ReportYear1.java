package org.example.model;

public class ReportYear1 {
    private Integer stdID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private Integer classID;
    private String stdBD;
    private Integer EFC;
    private Integer fundamental;
    private Integer math;
    private Integer pfc;
    private Integer the21;
    private Integer history;
    private Integer cProgram;
    private String Semester;
    private Double avg;

    public ReportYear1(Integer stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, Integer classID, String stdBD, Integer EFC, Integer fundamental, Integer math, Integer pfc, Integer the21, Integer history, Integer cProgram, String semester, Double avg) {
        this.stdID = stdID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
        this.EFC = EFC;
        this.fundamental = fundamental;
        this.math = math;
        this.pfc = pfc;
        this.the21 = the21;
        this.history = history;
        this.cProgram = cProgram;
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

    public Integer getEFC() {
        return EFC;
    }

    public Integer getFundamental() {
        return fundamental;
    }

    public Integer getMath() {
        return math;
    }

    public Integer getPfc() {
        return pfc;
    }

    public Integer getThe21() {
        return the21;
    }

    public Integer getHistory() {
        return history;
    }

    public Integer getcProgram() {
        return cProgram;
    }

    public String getSemester() {
        return Semester;
    }

    public Double getAvg() {
        return avg;
    }
}
