package org.example.view;

import org.example.controller.ReportController;
import org.example.util.ConvertFile;

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

    public ReportYear1View() {
        reportController = new ReportController();
        initializeUI();
        loadReports();
    }

    private void initializeUI() {
        setTitle("Report Year1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 750);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JButton year1 = new JButton("Year1");
        year1.setBounds(0, 10, 100, 30);
        year1.setBackground(Color.BLACK);
        year1.setForeground(Color.white);

        mainPanel.add(year1);

        // label name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(200, 30, 100, 30);
        mainPanel.add(lblName);

        // text field for filter by name
        txtName = new JTextField();
        txtName.setBounds(250, 30, 100, 30);
        mainPanel.add(txtName);

        // label class
        JLabel lblClass = new JLabel("Class");
        lblClass.setBounds(400, 30, 100, 30);
        mainPanel.add(lblClass);

        // text field class
        txtClass = new JTextField();
        txtClass.setBounds(450, 30, 100, 30);
        mainPanel.add(txtClass);

        // label genertaion
        JLabel lblGeneration = new JLabel("Generation");
        lblGeneration.setBounds(600, 30, 100, 30);
        mainPanel.add(lblGeneration);

        // text filed generation
        txtGeneration = new JTextField();
        txtGeneration.setBounds(680, 30, 100, 30);
        mainPanel.add(txtGeneration);

        JLabel lblStdCode = new JLabel("StdCode");
        lblStdCode.setBounds(820, 30, 100, 30);
        mainPanel.add(lblStdCode);

        txtStdCode = new JTextField();
        txtStdCode.setBounds(880, 30, 100, 30);
        mainPanel.add(txtStdCode);

        // Search button
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(1050, 30, 100, 30);
        mainPanel.add(btnSearch);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String classId = txtClass.getText();
                String generation = txtGeneration.getText();
                String stdCode = txtStdCode.getText();
                searchReports(name, classId, generation, stdCode);
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(50, 650, 100, 30);
        mainPanel.add(btnExit);

        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current form
                dispose();
                ReportOptionForm reportOptionForm = new ReportOptionForm();
                reportOptionForm.setVisible(true);
            }
        });

        JButton btnExcel = new JButton("Excel");
        btnExcel.setBounds(700, 650, 100, 30);
        mainPanel.add(btnExcel);

        btnExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertFile.exportToExcel(ReportYear1View.this, tableModel, "Year1");
            }
        });

        JButton btnPdf = new JButton("PDF");
        btnPdf.setBounds(850, 650, 100, 30);
        mainPanel.add(btnPdf);

        btnPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertFile.exportToPDF(ReportYear1View.this, tableModel, "Year1");
            }
        });

        // Create the table model and table
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Code", "Name", "Sex", "Fundamental", "Math", "PFC", "The21", "History", "CProgram"});
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
        tablePanel.setBorder(BorderFactory.createEmptyBorder(120, 50, 150, 50)); // Add margins here
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

    private void searchReports(String name, String classId, String generation, String stdCode) {
        try {
            List<org.example.model.ReportYear1> reports = reportController.searchReports(name, classId, generation, stdCode);
            updateTable(reports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTable(List<org.example.model.ReportYear1> reports) {
        tableModel.setRowCount(0); // Clear existing data
        for (org.example.model.ReportYear1 report : reports) {
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
