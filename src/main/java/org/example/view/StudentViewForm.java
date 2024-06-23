package org.example.view;

import org.example.controller.StudentController;
import org.example.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentViewForm extends JFrame {

    private final StudentController studentController;

    private final JTextField tfStdCode;
    private final JTextField tfStdName;
    private final JTextField tfStdSex;
    private final JTextField tfStdAdd;
    private final JTextField tfStdGrt;
    private final JTextField tfStdYear;
    private final JTextField tfClassID;
    private final JTextField tfStdBD;
    private final JTable table;
    private final DefaultTableModel tableModel;

    public StudentViewForm() {
        studentController = new StudentController();

        setTitle("Student Management");
        setSize(1400, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Sidebar Panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(39, 55, 70));
        sidebarPanel.setPreferredSize(new Dimension(150, getHeight()));

        JLabel userIcon = new JLabel(new ImageIcon("path/to/user/icon")); // Add your user icon path here
        userIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebarPanel.add(Box.createVerticalStrut(30)); // Add spacing
        sidebarPanel.add(userIcon);
        sidebarPanel.add(Box.createVerticalStrut(10)); // Add spacing

        JLabel userLabel = new JLabel("User");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userLabel.setForeground(Color.WHITE);
        sidebarPanel.add(userLabel);

        JButton btnLogout = new JButton("Log Out");
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBackground(Color.WHITE);
        sidebarPanel.add(Box.createVerticalStrut(300)); // Add spacing
        sidebarPanel.add(btnLogout);

        add(sidebarPanel, BorderLayout.WEST);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for absolute positioning
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblStdCode = new JLabel("Stu Code:");
        lblStdCode.setBounds(20, 20, 100, 25);
        formPanel.add(lblStdCode);

        tfStdCode = new JTextField();
        tfStdCode.setBounds(140, 20, 150, 25);
        formPanel.add(tfStdCode);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 60, 100, 25);
        formPanel.add(lblName);

        tfStdName = new JTextField();
        tfStdName.setBounds(140, 60, 150, 25);
        formPanel.add(tfStdName);

        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(20, 100, 100, 25);
        formPanel.add(lblSex);

        tfStdSex = new JTextField();
        tfStdSex.setBounds(140, 100, 150, 25);
        formPanel.add(tfStdSex);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(20, 140, 100, 25);
        formPanel.add(lblAddress);

        tfStdAdd = new JTextField();
        tfStdAdd.setBounds(140, 140, 150, 25);
        formPanel.add(tfStdAdd);

        JLabel lblGrade = new JLabel("Grade:");
        lblGrade.setBounds(20, 180, 100, 25);
        formPanel.add(lblGrade);

        tfStdGrt = new JTextField();
        tfStdGrt.setBounds(140, 180, 150, 25);
        formPanel.add(tfStdGrt);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(20, 220, 100, 25);
        formPanel.add(lblYear);

        tfStdYear = new JTextField();
        tfStdYear.setBounds(140, 220, 150, 25);
        formPanel.add(tfStdYear);

        JLabel lblClassID = new JLabel("Class ID:");
        lblClassID.setBounds(20, 260, 100, 25);
        formPanel.add(lblClassID);

        tfClassID = new JTextField();
        tfClassID.setBounds(140, 260, 150, 25);
        formPanel.add(tfClassID);

        JLabel lblBirthDate = new JLabel("Birth Date:");
        lblBirthDate.setBounds(20, 300, 100, 25);
        formPanel.add(lblBirthDate);

        tfStdBD = new JTextField();
        tfStdBD.setBounds(140, 300, 150, 25);
        formPanel.add(tfStdBD);

        /* Button */
        // button create student
        JButton btnCreate = new JButton("Create");
        btnCreate.setBackground(new Color(0, 128, 0));
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setBounds(30, 400, 100, 30);
        formPanel.add(btnCreate);

        // button update student
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(211, 147, 51, 242));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBounds(180, 400, 100, 30);
        formPanel.add(btnUpdate);

        // button delete
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(255, 0, 0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(30, 460, 100, 30);
        formPanel.add(btnDelete);

        // button exit
        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(Color.GRAY);
        btnExit.setForeground(Color.WHITE);
        btnExit.setBounds(180, 460, 100, 30);
        formPanel.add(btnExit);

        // add form panel into the form
        add(formPanel, BorderLayout.CENTER);

        // create
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createStudent();
                loadStudents();
            }
        });

        // update
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
                loadStudents();
            }
        });

         // delete
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
                loadStudents();
            }
        });

        // exit(back to home)
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current form
                dispose();

            }
        });

        // Table Panel
        tableModel = new DefaultTableModel(new String[]{"stdID", "stdCode", "stdName", "stdSex", "stdAdd", "stdGrt", "stdYear", "classID", "stdBD"}, 0);
        table = new JTable(tableModel);
        table.setRowHeight(20);
        table.setIntercellSpacing(new Dimension(5, 5)); // Add gap between cells
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    tfStdCode.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    tfStdName.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    tfStdSex.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    tfStdAdd.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    tfStdGrt.setText(tableModel.getValueAt(selectedRow, 5).toString());
                    tfStdYear.setText(tableModel.getValueAt(selectedRow, 6).toString());
                    tfClassID.setText(tableModel.getValueAt(selectedRow, 7).toString());
                    tfStdBD.setText(tableModel.getValueAt(selectedRow, 8).toString());
                }
            }
        });
        add(new JScrollPane(table), BorderLayout.EAST);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(340, 20, 800, 500);
        formPanel.add(scrollPane);

        loadStudents();
        setVisible(true);
    }

    private void loadStudents() {
        try {
            java.util.List<Student> students = studentController.loadStudents();
            tableModel.setRowCount(0); // Clear existing data
            for (Student student : students) {
                tableModel.addRow(new Object[]{
                        student.getStdID(),
                        student.getStdCode(),
                        student.getStdName(),
                        student.getStdSex(),
                        student.getStdAdd(),
                        student.getStdGrt(),
                        student.getStdYear(),
                        student.getClassID(),
                        student.getStdBD()
                });
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    private void createStudent() {
        String stdCode = tfStdCode.getText();
        String stdName = tfStdName.getText();
        String stdSex = tfStdSex.getText();
        String stdAdd = tfStdAdd.getText();
        String stdGrt = tfStdGrt.getText();
        String stdYear = tfStdYear.getText();
        int classID = Integer.parseInt(tfClassID.getText());
        String stdBD = tfStdBD.getText();
        Student newStudent = new Student(0, stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD); // Assuming stdID is autogenerated (0 or null)
        try {
            studentController.createStudent(newStudent);
            JOptionPane.showMessageDialog(this, "Student created successfully!");
            loadStudents(); // Reload the students after creating a new one
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error creating student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int stdID = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
            String stdCode = tfStdCode.getText();
            String stdName = tfStdName.getText();
            String stdSex = tfStdSex.getText();
            String stdAdd = tfStdAdd.getText();
            String stdGrt = tfStdGrt.getText();
            String stdYear = tfStdYear.getText();
            int classID = Integer.parseInt(tfClassID.getText());
            String stdBD = tfStdBD.getText();

            Student updatedStudent = new Student(stdID, stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD);

            try {
                studentController.updateStudent(updatedStudent);
                JOptionPane.showMessageDialog(this, "Student updated successfully!");
                loadStudents(); // Reload the students after updating
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int stdID = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    studentController.deleteStudent(stdID);
                    JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                    loadStudents(); // Reload the students after deleting
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentViewForm::new);
    }*/
}
