package org.example.model;

public class Student {
    private int stdID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private int classID;
    private String stdBD;

    public Student(){};

    public Student(int stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD) {
        this.stdID = stdID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
    }

    public Student(String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD) {
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classID = classID;
        this.stdBD = stdBD;
    }

    public int getStdID() {
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

    public int getClassID() {
        return classID;
    }

    public String getStdBD() {
        return stdBD;
    }
}
