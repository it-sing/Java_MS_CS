package org.example.view;

import org.example.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentView extends JFrame {
    private JTextField stuIDField, stdCodeField, stdNameField, stdSexField, birthField, stdAddField, stdGrtField, stdYearField, classIdField, stdDbField;
    private JButton submitButton, cancelButton, searchButton, updateButton, deleteButton;
    private JTable table;

    public StudentView() {
        setTitle("Student Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 750);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1080, 400);
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));

        addLabelAndField(panel, "Student ID:", 50, 50, 200, 30, stuIDField = new JTextField());
        addLabelAndField(panel, "Student Code:", 50, 100, 200, 30, stdCodeField = new JTextField());
        addLabelAndField(panel, "Student Name:", 50, 150, 200, 30, stdNameField = new JTextField());
        addLabelAndField(panel, "Sex:", 50, 200, 200, 30, stdSexField = new JTextField());
        addLabelAndField(panel, "Address:", 50, 250, 200, 30, stdAddField = new JTextField());
        addLabelAndField(panel, "Generation:", 530, 50, 200, 30, stdGrtField = new JTextField());
        addLabelAndField(panel, "Year:", 530, 100, 200, 30, stdYearField = new JTextField());
        addLabelAndField(panel, "Class ID:", 530, 150, 200, 30, classIdField = new JTextField());
        addLabelAndField(panel, "Date fo birth:", 530, 200, 200, 30, stdDbField = new JTextField());

        submitButton = new JButton("Create");
        submitButton.setBounds(50, 350, 100, 30);
        panel.add(submitButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(200, 350, 100, 30);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(350, 350, 100, 30);
        panel.add(deleteButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(500, 350, 100, 30);
        panel.add(searchButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(650, 350, 100, 30);
        panel.add(cancelButton);

        add(panel);

        JLabel listAllDataLabel = new JLabel("List of All Students:");
        listAllDataLabel.setBounds(0, 410, 1080, 30);
        listAllDataLabel.setFont(new Font("Arial", Font.BOLD, 16));
        listAllDataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(listAllDataLabel);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 450, 980, 230);
        add(scrollPane);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        scrollPane.setColumnHeaderView(header);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, cellRenderer);

        setVisible(true);
    }

    private void addLabelAndField(JPanel panel, String labelText, int x, int y, int width, int height, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, width, height);
        panel.add(label);
        textField.setBounds(x + 200, y, 200, height);
        panel.add(textField);
    }

    public String getStuIDField() {
        return stuIDField.getText();
    }

    public String getStdCodeField() {
        return stdCodeField.getText();
    }

    public String getStdNameField() {
        return stdNameField.getText();
    }

    public String getStdSexField() {
        return stdSexField.getText();
    }

    public String getBirthField() {
        return birthField.getText();
    }

    public String getStdAddField() {
        return stdAddField.getText();
    }

    public String getStdGrtField() {
        return stdGrtField.getText();
    }

    public String getStdYearField() {
        return stdYearField.getText();
    }

    public String getClassIdField() {
        return classIdField.getText();
    }

    public String getStdDbField() {
        return stdDbField.getText();
    }

    public void setTableData(DefaultTableModel model) {
        table.setModel(model);
    }

    public void setStudentFields(Student student) {
        stuIDField.setText(String.valueOf(student.getStuID()));
        stdCodeField.setText(student.getStdCode());
        stdNameField.setText(student.getStdName());
        stdSexField.setText(student.getStdSex());
        stdAddField.setText(student.getStdAdd());
        stdGrtField.setText(student.getStdGrt());
        stdYearField.setText(student.getStdYear());
        classIdField.setText(student.getClassId());
        stdDbField.setText(student.getStdDb());
    }

    public void clearFields() {
        stuIDField.setText("");
        stdCodeField.setText("");
        stdNameField.setText("");
        stdSexField.setText("");
        birthField.setText("");
        stdAddField.setText("");
        stdGrtField.setText("");
        stdYearField.setText("");
        classIdField.setText("");
        stdDbField.setText("");
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void addUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}
