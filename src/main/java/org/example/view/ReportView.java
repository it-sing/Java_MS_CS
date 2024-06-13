package org.example.view;

import org.example.controller.ReportController;
import org.example.model.Report;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ReportView extends JFrame {
    private DefaultTableModel tableModel;
    private final ReportController reportController;

    public ReportView() {
        reportController = new ReportController();
        initializeUI();
        loadReports();
    }

    private void initializeUI() {
        setTitle("Report Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

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
        tablePanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Add margins here
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField searchField = new JTextField(20);
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton excelButton = new JButton("Excel");
        JButton pdfButton = new JButton("PDF");
        bottomPanel.add(excelButton);
        bottomPanel.add(pdfButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadReports() {
        try {
            List<Report> reports = reportController.loadReports();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReportView view = new ReportView();
            view.setVisible(true);
        });
    }
}
