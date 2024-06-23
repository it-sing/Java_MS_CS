package org.example.model;

public class ReportYear4 extends Student {

    private final Integer ooad;
    private final Integer web;
    private final Integer linux;
    private final Integer mis;
    private final Integer se;
    private final String Semester;
    private final Double avg;


    public ReportYear4(int stdID, String stdCode, String stdName, String stdSex, String stdAdd, String stdGrt, String stdYear, int classID, String stdBD, Integer ooad, Integer web, Integer linux, Integer mis, Integer se, String semester, Double avg) {
        super(stdID, stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD);
        this.ooad = ooad;
        this.web = web;
        this.linux = linux;
        this.mis = mis;
        this.se = se;
        Semester = semester;
        this.avg = avg;
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
