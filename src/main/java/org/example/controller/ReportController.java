package org.example.controller;

import org.example.model.Report;
import org.example.repository.ReportRepository;

import java.util.List;

public class ReportController {
    private final ReportRepository repository;

    public ReportController() {
        repository = new ReportRepository();
    }

    public List<Report> loadReportsYear1() {
        return repository.getAllReportsYear1();
    }

    public List<Report> searchReportsByNameYear1(List<String> names) {
        return repository.searchReportsByNameYear1(names);
    }
}
