package org.example.model;

public class ReportYear1 {
    private int stdID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private int classID;
    private String stdBD;
    private int fundamental;
    private int math;
    private int pfc;
    private int the21;
    private int history;
    private int cProgram;

    public ReportYear1(){};

    public ReportYear1(int stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD, int fundamental, int math, int pfc, int the21, int history, int cProgram) {
        this.stdID = stdID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
        this.fundamental = fundamental;
        this.math = math;
        this.pfc = pfc;
        this.the21 = the21;
        this.history = history;
        this.cProgram = cProgram;
    }

    public int getStdID() {
        return stdID;
    }

    public void setStdID(int stdID) {
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

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getStdBD() {
        return stdBD;
    }

    public void setStdBD(String stdBD) {
        this.stdBD = stdBD;
    }

    public int getFundamental() {
        return fundamental;
    }

    public void setFundamental(int fundamental) {
        this.fundamental = fundamental;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getPfc() {
        return pfc;
    }

    public void setPfc(int pfc) {
        this.pfc = pfc;
    }

    public int getThe21() {
        return the21;
    }

    public void setThe21(int the21) {
        this.the21 = the21;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getcProgram() {
        return cProgram;
    }

    public void setcProgram(int cProgram) {
        this.cProgram = cProgram;
    }
}
