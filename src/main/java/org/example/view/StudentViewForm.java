package org.example.view;

import org.example.controller.StudentController;
import org.example.controller.UserController;
import org.example.model.Student;
import org.example.repository.UserRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
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
        Font fontBold = new Font("Roboto", Font.PLAIN, 14);
        Font fontNormal = new Font("Roboto", Font.PLAIN, 14);

        setTitle("Student Management");
        setFont(fontBold);
        setSize(1500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Sidebar Panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(84, 43, 154));
        sidebarPanel.setPreferredSize(new Dimension(150, getHeight()));

        JLabel userLabel = new JLabel("User");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userLabel.setForeground(Color.WHITE);
        sidebarPanel.add(userLabel);

        JButton btnLogout = new JButton("Log Out");
        btnLogout.setBounds(10, 400, 100, 30);

        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setBackground(Color.WHITE);
        sidebarPanel.add(Box.createVerticalStrut(400)); // Add spacing
        sidebarPanel.add(btnLogout);
        add(sidebarPanel, BorderLayout.WEST);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for absolute positioning
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblCode = new JLabel("Code:");
        lblCode.setBounds(20, 20, 100, 25);
        formPanel.add(lblCode);

        tfStdCode = new JTextField();
        tfStdCode.setBounds(140, 20, 150, 25);
        tfStdCode.setEditable(false);
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

        cbStdSex = new JComboBox<>(new String[]{"Male", "Female"});
        cbStdSex.setBounds(140, 100, 150, 25);
        formPanel.add(cbStdSex);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(20, 140, 100, 25);
        formPanel.add(lblAddress);

        tfStdAdd = new JTextField();
        tfStdAdd.setBounds(140, 140, 150, 25);
        formPanel.add(tfStdAdd);

        JLabel lblGrade = new JLabel("Generation:");
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

        // log out
        btnLogout.addActionListener(e -> {
            dispose();
            SignInForm signInForm = new SignInForm();
            SignUpForm signUpForm = new SignUpForm();
            UserRepository userRepository = new UserRepository();
            UserController controller = new UserController(signInForm, signUpForm, userRepository);
            signInForm.setVisible(true);
        });

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
            dispose();
            DashboardForm dashboardForm = new DashboardForm();
            dashboardForm.setVisible(true);
        });

        // Table Panel
        tableModel = new DefaultTableModel(new String[]{
                "Student ID", "Code", "Student Name", "Gender", "Address", "Generation", "Year", "Class ID", "Date of Birth"
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
                    tfStdCode.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    tfStdName.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    cbStdSex.setSelectedItem(tableModel.getValueAt(selectedRow, 3).toString());
                    tfStdAdd.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    tfStdGrt.setText(tableModel.getValueAt(selectedRow, 5).toString());
                    tfStdYear.setText(tableModel.getValueAt(selectedRow, 6).toString());
                    tfClassID.setText(tableModel.getValueAt(selectedRow, 7).toString());
                    tfStdBD.setText(tableModel.getValueAt(selectedRow, 8).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(330, 20, 920, 480);
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
        String stdName = tfStdName.getText();
        String stdSex = (String) cbStdSex.getSelectedItem();
        String stdAdd = tfStdAdd.getText();
        String stdGrt = tfStdGrt.getText();
        String stdYear = tfStdYear.getText();
        int classID = Integer.parseInt(tfClassID.getText());
        String stdBD = tfStdBD.getText();
        Student newStudent = new Student(0, null, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD); // Assuming stdID is autogenerated (0 or null)
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
            String stdCode = tableModel.getValueAt(selectedRow, 1).toString();
            String stdName = tfStdName.getText();
            String stdSex = (String) cbStdSex.getSelectedItem();
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

}
