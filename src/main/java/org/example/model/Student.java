package org.example.model;


public class Student{
    private Integer stuID;
    private String stdCode;
    private String stdName;
    private String stdSex;
    private String stdAdd;
    private String stdGrt;
    private String stdYear;
    private String classId;
    private String stdDb;

    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStdDb() {
        return stdDb;
    }

    public void setStdDb(String stdDb) {
        this.stdDb = stdDb;
    }

    public Student(){};

    public Student(Integer stuID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, String classId, String stdDb) {
        this.stuID = stuID;
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdSex = stdSex;
        this.stdAdd = stdAdd;
        this.stdGrt = stdGrt;
        this.stdYear = stdYear;
        this.classId = classId;
        this.stdDb = stdDb;
    }
}
