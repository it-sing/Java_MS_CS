package org.example.controller;
import org.example.model.ReportYear1;
import org.example.model.ReportYear2;
import org.example.model.ReportYear3;
import org.example.model.ReportYear4;
import org.example.repository.ReportRepository;

import java.util.List;

public class ReportController {
    private final ReportRepository repository;

    public ReportController() {
        repository = new ReportRepository();
    }

    public List<ReportYear1> loadReportsYear1() {
        return repository.getAllReportsYear1();
    }

    public List<ReportYear1> searchReportsYear1(String name, String classId, String generation, String stdCode, String semester) {
        return repository.searchReportsYear1(name, classId, generation, stdCode, semester);
    }

    public List<ReportYear2> loadReportsYear2(){
        return repository.getAllReportsYear2();
    }

    public List<ReportYear2> searchReportsYear2(String name, String classId, String generation, String stdCode, String semester) {
        return repository.searchReportsYear2(name, classId, generation, stdCode, semester);
    }

    public List<ReportYear3> loadReportsYear3(){
        return repository.getAllReportsYear3();
    }

    public List<ReportYear3> searchReportsYear3(String name, String classId, String generation, String stdCode, String semester) {
        return repository.searchReportsYear3(name, classId, generation, stdCode, semester);
    }

    public List<ReportYear4> loadReportsYear4(){
        return repository.getAllReportsYear4();
    }

    public List<ReportYear4> searchReportsYear4(String name, String classId, String generation, String stdCode, String semester) {
        return repository.searchReportsYear4(name, classId, generation, stdCode, semester);
    }

}

