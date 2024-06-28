package org.example.view;

import org.example.controller.StudentController;
import org.example.model.Student;
import org.example.model.UserDetails;
import org.example.model.UserRole;
import org.example.model.UserSession;
import org.example.util.Message;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.sql.SQLException;

public class StudentViewForm extends JFrame {

    private final StudentController studentController;

    private final JTextField tfStdCode;
    private final JTextField tfStdName;
    private final JComboBox<String> cbStdSex;
    private final JTextField tfStdAdd;
    private final JTextField tfStdGrt;
    private final JTextField tfStdYear;
    private final JTextField tfClassID;
    private final JTextField tfStdBD;
    private final JTable table;
    private final DefaultTableModel tableModel;

    public StudentViewForm() {
        studentController = new StudentController();

        // Set font size
        Font fontBold = new Font("Khmer OS", Font.PLAIN, 14);
        Font fontNormal = new Font("Khmer OS", Font.PLAIN, 14);

        setTitle("Student Management");
        setFont(fontBold);
        setSize(1400, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for absolute positioning
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblCode = new JLabel("Code:");
        lblCode.setBounds(30, 20, 100, 25);
        formPanel.add(lblCode);

        tfStdCode = new JTextField();
        tfStdCode.setBounds(150, 20, 150, 25);
        tfStdCode.setEditable(false);
        formPanel.add(tfStdCode);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 60, 100, 25);
        formPanel.add(lblName);

        tfStdName = new JTextField();
        tfStdName.setBounds(150, 60, 150, 25);
        formPanel.add(tfStdName);

        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(30, 100, 100, 25);
        formPanel.add(lblSex);

        cbStdSex = new JComboBox<>(new String[]{"Male", "Female"});
        cbStdSex.setBounds(150, 100, 150, 25);
        formPanel.add(cbStdSex);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 140, 100, 25);
        formPanel.add(lblAddress);

        tfStdAdd = new JTextField();
        tfStdAdd.setBounds(150, 140, 150, 25);
        formPanel.add(tfStdAdd);

        JLabel lblGrade = new JLabel("Generation:");
        lblGrade.setBounds(30, 180, 100, 25);
        formPanel.add(lblGrade);

        tfStdGrt = new JTextField();
        tfStdGrt.setBounds(150, 180, 150, 25);
        formPanel.add(tfStdGrt);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setBounds(30, 220, 100, 25);
        formPanel.add(lblYear);

        tfStdYear = new JTextField();
        tfStdYear.setBounds(150, 220, 150, 25);
        formPanel.add(tfStdYear);

        JLabel lblClassID = new JLabel("Class ID:");
        lblClassID.setBounds(30, 260, 100, 25);
        formPanel.add(lblClassID);

        tfClassID = new JTextField();
        tfClassID.setBounds(150, 260, 150, 25);
        formPanel.add(tfClassID);

        JLabel lblBirthDate = new JLabel("Birth Date:");
        lblBirthDate.setBounds(30, 300, 100, 25);
        formPanel.add(lblBirthDate);

        tfStdBD = new JTextField();
        tfStdBD.setBounds(150, 300, 150, 25);
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
        btnCreate.addActionListener(e -> {
            createStudent();
            loadStudents();
        });

        // update
        btnUpdate.addActionListener(e -> {
            updateStudent();
            loadStudents();
        });

        // delete
        btnDelete.addActionListener(e -> {
            deleteStudent();
            loadStudents();
        });

        // exit(back to home)
        btnExit.addActionListener(e -> {
            // Close the current form
            dispose();
        });

        // Table Panel
        tableModel = new DefaultTableModel(new String[]{
                "Std Code", "Student Name", "Gender", "Address", "Generation", "Year", "Class ID", "Date of Birth"
        }, 0);
        table = new JTable(tableModel);
        table.setFont(fontNormal);
        table.setRowHeight(25);
        table.setIntercellSpacing(new Dimension(5, 5)); // Add gap between cells

        // Set font size bold for header of table
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(fontBold);

        // Center align all cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    tfStdCode.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    tfStdName.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    cbStdSex.setSelectedItem(tableModel.getValueAt(selectedRow, 2).toString());
                    tfStdAdd.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    tfStdGrt.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    tfStdYear.setText(tableModel.getValueAt(selectedRow, 5).toString());
                    tfClassID.setText(tableModel.getValueAt(selectedRow, 6).toString());
                    tfStdBD.setText(tableModel.getValueAt(selectedRow, 7).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(360, 20, 920, 480);
        formPanel.add(scrollPane);

        loadStudents();
        setVisible(true);
    }
    private UserDetails getCurrentUser() {
        UserDetails currentUser = UserSession.getInstance().getCurrentUser();

        if (currentUser != null) {
            String currentFullName = currentUser.getFullName();
            String currentUsername = currentUser.getUsername();
            UserRole userRole = currentUser.getRole();
            InputStream profileInputStream = currentUser.getProfileInputStream(); // Use updated method

            return new UserDetails(currentFullName, currentUsername, profileInputStream, userRole);
        } else {
            System.out.println("No current user in session.");
            return null;
        }
    }
    private void loadStudents() {
        try {
            UserDetails currentUser = getCurrentUser();
            java.util.List<Student> students = studentController.loadStudents(currentUser);
            tableModel.setRowCount(0); // Clear existing data
            for (Student student : students) {
                tableModel.addRow(new Object[]{
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
        } catch (SecurityException se) {
            Message.showErrorMessage("Permission denied: " + se.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createStudent() {
        try{
            UserDetails currentUser = getCurrentUser();
            String stdName = tfStdName.getText();
            String stdSex = (String) cbStdSex.getSelectedItem();
            String stdAdd = tfStdAdd.getText();
            String stdGrt = tfStdGrt.getText();
            String stdYear = tfStdYear.getText();
            int classID = Integer.parseInt(tfClassID.getText());
            String stdBD = tfStdBD.getText();
            Student newStudent = new Student(null, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD); // Assuming stdID is autogenerated (0 or null)
            try {
                studentController.createStudent(currentUser,newStudent);
                JOptionPane.showMessageDialog(this, "Student created successfully!");
                loadStudents(); // Reload the students after creating a new one
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error creating student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (SecurityException se) {
            Message.showErrorMessage("Permission denied: " + se.getMessage());
        }

    }



    private void updateStudent() {
        try {
            UserDetails currentUser = getCurrentUser();

            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String stdCode = tableModel.getValueAt(selectedRow, 0).toString(); // Column index for stdCode
                String stdName = tfStdName.getText();
                String stdSex = (String) cbStdSex.getSelectedItem();
                String stdAdd = tfStdAdd.getText();
                String stdGrt = tfStdGrt.getText();
                String stdYear = tfStdYear.getText();
                int classID = Integer.parseInt(tfClassID.getText());
                String stdBD = tfStdBD.getText();

                Student updatedStudent = new Student(stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD);

                try {
                    studentController.updateStudent(currentUser, updatedStudent);
                    JOptionPane.showMessageDialog(this, "Student updated successfully!");
                    loadStudents(); // Reload the students after updating
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a student to update.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SecurityException se) {
            Message.showErrorMessage("Permission denied: " + se.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            UserDetails currentUser = getCurrentUser();

            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String stdCode = tableModel.getValueAt(selectedRow, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        studentController.deleteStudent(currentUser, stdCode);
                        JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                        loadStudents(); // Reload the students after deleting
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a student to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SecurityException se) {
            Message.showErrorMessage(this, "Permission denied: " + se.getMessage());
        }
    }


}
