package org.example.view;

import org.example.controller.ReportController;
import org.example.util.ConvertFile;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ReportYear4View extends JFrame {

    private DefaultTableModel tableModel;
    private final ReportController reportController;
    private JTextField txtName;
    private JTextField txtClass;
    private JTextField txtGeneration;
    private JTextField txtStdCode;
    private JTextField txtSemester;

    public ReportYear4View() {
        reportController = new ReportController();
        initializeUI();
        loadReports();
    }

    private void initializeUI() {
        setTitle("Report Year4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 750);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JButton year1 = new JButton("Year4");
        year1.setBounds(0, 5, 100, 30);
        year1.setBackground(Color.BLACK);
        year1.setForeground(Color.white);

        mainPanel.add(year1);

        // label semester
        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(60, 50, 100, 30);
        mainPanel.add(lblSemester);

        // text filed semester
        txtSemester = new JTextField();
        txtSemester.setBounds(130,50, 120, 30);
        mainPanel.add(txtSemester);

        // label name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(300, 50, 100, 30);
        mainPanel.add(lblName);

        // text field for filter by name
        txtName = new JTextField();
        txtName.setBounds(350, 50, 100, 30);
        mainPanel.add(txtName);

        // label class
        JLabel lblClass = new JLabel("Class");
        lblClass.setBounds(500, 50, 100, 30);
        mainPanel.add(lblClass);

        // text field class
        txtClass = new JTextField();
        txtClass.setBounds(550, 50, 100, 30);
        mainPanel.add(txtClass);

        // label generation
        JLabel lblGeneration = new JLabel("Generation");
        lblGeneration.setBounds(680, 50, 100, 30);
        mainPanel.add(lblGeneration);

        // text filed generation
        txtGeneration = new JTextField();
        txtGeneration.setBounds(750, 50, 100, 30);
        mainPanel.add(txtGeneration);

        JLabel lblStdCode = new JLabel("StdCode");
        lblStdCode.setBounds(900, 50, 100, 30);
        mainPanel.add(lblStdCode);

        txtStdCode = new JTextField();
        txtStdCode.setBounds(960, 50, 100, 30);
        mainPanel.add(txtStdCode);

        // Search button
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(1120, 50, 100, 30);
        btnSearch.setBackground(new Color(37, 99, 235));
        btnSearch.setForeground(Color.white);
        mainPanel.add(btnSearch);

        btnSearch.addActionListener(e -> {
            String name = txtName.getText();
            String classId = txtClass.getText();
            String generation = txtGeneration.getText();
            String stdCode = txtStdCode.getText();
            String semester = txtSemester.getText();
            searchReports(name, classId, generation, stdCode, semester);
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(50, 650, 100, 30);
        btnExit.setBackground(new Color(225, 29, 72));
        btnExit.setForeground(Color.white);
        mainPanel.add(btnExit);

        btnExit.addActionListener(e -> {
            dispose();
            ReportOptionForm reportOptionForm = new ReportOptionForm();
            reportOptionForm.setVisible(true);
        });

        JButton btnExcel = new JButton("Excel");
        btnExcel.setBounds(970, 650, 100, 30);
        btnExcel.setBackground(new Color(16, 185, 129));
        btnExcel.setForeground(Color.white);
        mainPanel.add(btnExcel);

        btnExcel.addActionListener(e -> ConvertFile.exportToExcel(ReportYear4View.this, tableModel, "Year1"));

        JButton btnPdf = new JButton("PDF");
        btnPdf.setBounds(1120, 650, 100, 30);
        btnPdf.setBackground(new Color(37, 99, 235));
        btnPdf.setForeground(Color.white);
        mainPanel.add(btnPdf);

        btnPdf.addActionListener(e -> ConvertFile.exportToPDF(ReportYear4View.this, tableModel, "Year2"));

        // Create the table model and table
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"Student Code", "Name", "Sex", "OOAD", "Web", "Linux", "MIS", "SE", "Semester", "AVG"});
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Center data in the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Set color for the header text
        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.BLUE); // Set your desired text color here

        // Put the table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel with margins and add the scroll pane to it
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(120, 30, 200, 30)); // Add margins here
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);
    }

    private void loadReports() {
        try {
            List<org.example.model.ReportYear4> reportYear4s = reportController.loadReportsYear4();
            updateTable(reportYear4s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchReports(String name, String classId, String generation, String stdCode, String semester) {
        try {
            List<org.example.model.ReportYear4> reports = reportController.searchReportsYear4(name, classId, generation, stdCode, semester);
            updateTable(reports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable(List<org.example.model.ReportYear4> reports) {
        tableModel.setRowCount(0); // Clear existing data
        for (org.example.model.ReportYear4 report : reports) {
            tableModel.addRow(new Object[]{
                    report.getStdCode(),
                    report.getStdName(),
                    report.getStdSex(),
                    report.getOoad(),
                    report.getWeb(),
                    report.getLinux(),
                    report.getMis(),
                    report.getSe(),
                    report.getSemester(),
                    String.format("%.2f", report.getAvg())
            });
        }
    }
}

