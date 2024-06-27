package org.example.model;

public class ReportYear1 extends Student{

    private final Integer EFC;
    private final Integer fundamental;
    private final Integer math;
    private final Integer pfc;
    private final Integer the21;
    private final Integer history;
    private final Integer cProgram;
    private final String Semester;
    private final Double avg;


    public ReportYear1(String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD, Integer EFC, Integer fundamental, Integer math, Integer pfc, Integer the21, Integer history, Integer cProgram, String semester, Double avg) {
        super(stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD);
        this.EFC = EFC;
        this.fundamental = fundamental;
        this.math = math;
        this.pfc = pfc;
        this.the21 = the21;
        this.history = history;
        this.cProgram = cProgram;
        Semester = semester;
        this.avg = avg;
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

    public Integer getCProgram() {
        return cProgram;
    }

    public String getSemester() {
        return Semester;
    }

    public Double getAvg() {
        return avg;
    }
}
