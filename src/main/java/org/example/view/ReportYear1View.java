package org.example.view;

import org.example.controller.ReportController;
import org.example.util.ConvertFile;
import org.example.util.ModernButton;
import org.example.util.ModernButton;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReportYear1View extends JFrame {

    private DefaultTableModel tableModel;
    private final ReportController reportController;
    private JTextField txtName;
    private JTextField txtClass;
    private JTextField txtGeneration;
    private JTextField txtStdCode;
    private JTextField txtSemester;

    public ReportYear1View() {
        reportController = new ReportController();
        initializeUI();
        loadReports();
    }

    private void initializeUI() {
        setTitle("Report Year1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 750);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JButton year1 = new JButton("Year1");
        year1.setBounds(0, 5, 100, 30);
        year1.setBackground(Color.BLACK);
        year1.setForeground(Color.white);
        mainPanel.add(year1);

        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(60, 50, 100, 30);
        mainPanel.add(lblSemester);

        txtSemester = new JTextField();
        txtSemester.setBounds(130, 50, 120, 30);
        mainPanel.add(txtSemester);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(300, 50, 100, 30);
        mainPanel.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(350, 50, 100, 30);
        mainPanel.add(txtName);

        JLabel lblClass = new JLabel("Class");
        lblClass.setBounds(500, 50, 100, 30);
        mainPanel.add(lblClass);

        txtClass = new JTextField();
        txtClass.setBounds(550, 50, 100, 30);
        mainPanel.add(txtClass);

        JLabel lblGeneration = new JLabel("Generation");
        lblGeneration.setBounds(680, 50, 100, 30);
        mainPanel.add(lblGeneration);

        txtGeneration = new JTextField();
        txtGeneration.setBounds(750, 50, 100, 30);
        mainPanel.add(txtGeneration);

        JLabel lblStdCode = new JLabel("StdCode");
        lblStdCode.setBounds(900, 50, 100, 30);
        mainPanel.add(lblStdCode);

        txtStdCode = new JTextField();
        txtStdCode.setBounds(960, 50, 100, 30);
        mainPanel.add(txtStdCode);

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

        btnExcel.addActionListener(e -> ConvertFile.exportToExcel(ReportYear1View.this, tableModel, "Year1"));

        JButton btnPdf = new JButton("PDF");
        btnPdf.setBounds(1120, 650, 100, 30);
        btnPdf.setBackground(new Color(37, 99, 235));
        btnPdf.setForeground(Color.white);
        mainPanel.add(btnPdf);

        btnPdf.addActionListener(e -> ConvertFile.exportToPDF(ReportYear1View.this, tableModel, "Year1"));

        // Create the table model and table
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"Std Code", "Name", "Sex", "EFC", "Fundamental", "Math", "PFC", "The21", "History", "CProgram", "Semester", "AVG"});
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.BLUE);

        JScrollPane scrollPane = new JScrollPane(table);
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(120, 30, 200, 30));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);
    }

    private void loadReports() {
        try {
            List<org.example.model.ReportYear1> reports = reportController.loadReportsYear1();
            updateTable(reports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchReports(String name, String classId, String generation, String stdCode, String semester) {
        try {
            List<org.example.model.ReportYear1> reports = reportController.searchReportsYear1(name, classId, generation, stdCode, semester);
            updateTable(reports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable(List<org.example.model.ReportYear1> reports) {
        tableModel.setRowCount(0);
        for (org.example.model.ReportYear1 report : reports) {
            tableModel.addRow(new Object[]{
                    report.getStdCode(),
                    report.getStdName(),
                    report.getStdSex(),
                    report.getEFC(),
                    report.getFundamental(),
                    report.getMath(),
                    report.getPfc(),
                    report.getThe21(),
                    report.getHistory(),
                    report.getCProgram(),
                    report.getSemester(),
                    String.format("%.2f", report.getAvg())
            });
        }
    }
}
