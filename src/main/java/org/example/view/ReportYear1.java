package org.example.view;

import org.example.controller.ReportController;
import org.example.model.Report;
import org.example.util.ConvertFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class ReportYear1 extends JFrame {
    private DefaultTableModel tableModel;
    private final ReportController reportController;
    private JTextField txtName;

    public ReportYear1() {
        reportController = new ReportController();
        initializeUI();
        loadReports();
    }

    private void initializeUI() {
        setTitle("Report Year1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JButton year1 = new JButton("Year1");
        year1.setBounds(50, 30, 100, 30);
        year1.setBackground(Color.BLACK);
        year1.setForeground(Color.white);

        mainPanel.add(year1);

        // label
        JLabel lblName = new JLabel("Search by Name");
        lblName.setBounds(300, 30, 100, 30);
        mainPanel.add(lblName);

        // text field for filter by name
        txtName = new JTextField();
        txtName.setBounds(400, 30, 100, 30);
        mainPanel.add(txtName);

        // Search button
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(510, 30, 100, 30);
        mainPanel.add(btnSearch);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namesText = txtName.getText();
                List<String> names = Arrays.asList(namesText.split(","));
                searchReportsByName(names);
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(50, 650, 100, 30);
        mainPanel.add(btnExit);

        JButton btnExcel = new JButton("Excel");
        btnExcel.setBounds(700, 650, 100, 30);
        mainPanel.add(btnExcel);

        btnExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertFile.exportToExcel(ReportYear1.this, tableModel, "Year1");
            }
        });

        JButton btnPdf = new JButton("PDF");
        btnPdf.setBounds(850, 650, 100, 30);
        mainPanel.add(btnPdf);

        btnPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertFile.exportToPDF(ReportYear1.this, tableModel, "Year1");
            }
        });

        // Create the table model and table
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Code", "Name", "Sex", "Fundamental", "Math", "PFC", "The21", "History", "CProgram"});
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Put the table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel with margins and add the scroll pane to it
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 150, 50)); // Add margins here
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);
    }

    private void loadReports() {
        try {
            List<Report> reports = reportController.loadReportsYear1();
            updateTable(reports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchReportsByName(List<String> names) {
        try {
            List<Report> reports = reportController.searchReportsByNameYear1(names);
            updateTable(reports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable(List<Report> reports) {
        tableModel.setRowCount(0); // Clear existing data
        for (Report report : reports) {
            tableModel.addRow(new Object[]{
                    report.getStdID(),
                    report.getStdCode(),
                    report.getStdName(),
                    report.getStdSex(),
                    report.getFundamental(),
                    report.getMath(),
                    report.getPfc(),
                    report.getThe21(),
                    report.getHistory(),
                    report.getcProgram()
            });
        }
    }
}
