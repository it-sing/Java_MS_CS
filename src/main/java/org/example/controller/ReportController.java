package org.example.controller;

import org.example.model.Report;
import org.example.repository.ReportRepository;

import java.util.List;

public class ReportController {
    private final ReportRepository repository;

    public ReportController() {
        repository = new ReportRepository();
    }

    public List<Report> loadReports() {
        return repository.getAllReports();
    }
}
