package org.example.controller;
import org.example.model.ReportYear1;
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

    public List<ReportYear1> searchReports(String name, String classId, String generation, String stdCode) {
        return repository.searchReports(name, classId, generation, stdCode);
    }
}

