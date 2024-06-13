package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentViewForm extends JFrame {
    private static final String DATABASE_URL = "jdbc:ucanaccess://D:/9. RUPP/Year3/Java E7/ManagementPointStudent.accdb";

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

        add(formPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); // Use null layout for absolute positioning
        buttonPanel.setPreferredSize(new Dimension(600, 50)); // Set preferred size for visibility

        JButton btnCreate = new JButton("Create");
        btnCreate.setBackground(new Color(0, 128, 0));
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setBounds(200, 10, 100, 30); // Set position and size
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createStudent();
                loadStudents();
            }
        });
        buttonPanel.add(btnCreate);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(255, 255, 0));
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setBounds(320, 10, 100, 30); // Set position and size
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
                loadStudents();
            }
        });
        buttonPanel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(255, 0, 0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(440, 10, 100, 30); // Set position and size
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
                loadStudents();
            }
        });
        buttonPanel.add(btnDelete);

        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(Color.GRAY);
        btnExit.setForeground(Color.WHITE);
        btnExit.setBounds(560, 10, 100, 30); // Set position and size
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(btnExit);

        add(buttonPanel, BorderLayout.SOUTH);

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
        scrollPane.setBounds(320, 20, 800, 500);
        formPanel.add(scrollPane);

        loadStudents();

        setVisible(true);
    }

    private void loadStudents() {
        tableModel.setRowCount(0);
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT * FROM tbStudent";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tableModel.addRow(new Object[]{
                        resultSet.getInt("stdID"),
                        resultSet.getString("stdCode"),
                        resultSet.getString("stdName"),
                        resultSet.getString("stdSex"),
                        resultSet.getString("stdAdd"),
                        resultSet.getString("stdGrt"),
                        resultSet.getString("stdYear"),
                        resultSet.getInt("classID"),
                        resultSet.getDate("stdBD")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createStudent() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "INSERT INTO tbStudent (stdCode, stdName, stdSex, stdAdd, stdGrt, stdYear, classID, stdBD) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tfStdCode.getText());
            statement.setString(2, tfStdName.getText());
            statement.setString(3, tfStdSex.getText());
            statement.setString(4, tfStdAdd.getText());
            statement.setString(5, tfStdGrt.getText());
            statement.setString(6, tfStdYear.getText());
            statement.setInt(7, Integer.parseInt(tfClassID.getText()));
            statement.setDate(8, Date.valueOf(tfStdBD.getText()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int studentId = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
            try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
                String query = "UPDATE tbStudent SET stdCode = ?, stdName = ?, stdSex = ?, stdAdd = ?, stdGrt = ?, stdYear = ?, classID = ?, stdBD = ? WHERE stdID = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, tfStdCode.getText());
                statement.setString(2, tfStdName.getText());
                statement.setString(3, tfStdSex.getText());
                statement.setString(4, tfStdAdd.getText());
                statement.setString(5, tfStdGrt.getText());
                statement.setString(6, tfStdYear.getText());
                statement.setInt(7, Integer.parseInt(tfClassID.getText()));
                statement.setDate(8, Date.valueOf(tfStdBD.getText()));
                statement.setInt(9, studentId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int studentId = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
            try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
                String query = "DELETE FROM tbStudent WHERE stdID = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, studentId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentViewForm::new);
    }
}
