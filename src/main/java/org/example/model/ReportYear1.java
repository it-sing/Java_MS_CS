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

    public ReportYear1(){};

    public ReportYear1(Integer stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, Integer classID, String stdBD, Integer EFC, Integer fundamental, Integer math, Integer pfc, Integer the21, Integer history, Integer cProgram, String semester) {
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

    public Integer getEFC() {
        return EFC;
    }

    public void setEFC(Integer EFC) {
        this.EFC = EFC;
    }

    public Integer getFundamental() {
        return fundamental;
    }

    public void setFundamental(Integer fundamental) {
        this.fundamental = fundamental;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getPfc() {
        return pfc;
    }

    public void setPfc(Integer pfc) {
        this.pfc = pfc;
    }

    public Integer getThe21() {
        return the21;
    }

    public void setThe21(Integer the21) {
        this.the21 = the21;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public Integer getcProgram() {
        return cProgram;
    }

    public void setcProgram(Integer cProgram) {
        this.cProgram = cProgram;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
}
