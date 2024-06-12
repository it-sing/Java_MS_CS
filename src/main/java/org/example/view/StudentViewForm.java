package org.example.view;

import net.ucanaccess.jdbc.UcanaccessDriver;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setSize(1200, 650);
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
        formPanel.setLayout(new GridLayout(9, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel stdCode = new JLabel("Stu Code");
        stdCode.setBounds(100, 100, 100, 30);
        formPanel.add(stdCode);

        tfStdCode = new JTextField();
        formPanel.add(tfStdCode);

        formPanel.add(new JLabel("Name:"));
        tfStdName = new JTextField();
        formPanel.add(tfStdName);

        formPanel.add(new JLabel("Sex:"));
        tfStdSex = new JTextField();
        formPanel.add(tfStdSex);

        formPanel.add(new JLabel("Address:"));
        tfStdAdd = new JTextField();
        formPanel.add(tfStdAdd);

        formPanel.add(new JLabel("Grade:"));
        tfStdGrt = new JTextField();
        formPanel.add(tfStdGrt);

        formPanel.add(new JLabel("Year:"));
        tfStdYear = new JTextField();
        formPanel.add(tfStdYear);

        formPanel.add(new JLabel("Class ID:"));
        tfClassID = new JTextField();
        formPanel.add(tfClassID);

        formPanel.add(new JLabel("Birth Date:"));
        tfStdBD = new JTextField();
        formPanel.add(tfStdBD);

        add(formPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnCreate = new JButton("Create");
        btnCreate.setBackground(new Color(0, 128, 0));
        btnCreate.setForeground(Color.WHITE);
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
        table.setRowHeight(30);
        table.setIntercellSpacing(new Dimension(5, 5)); // Add gap between cells
        add(new JScrollPane(table), BorderLayout.EAST);

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
            JOptionPane.showMessageDialog(this, "Error loading students: " + e.getMessage());
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
            statement.setString(8, tfStdBD.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating student: " + e.getMessage());
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
                String query = "UPDATE tbStudent SET stdCode=?, stdName=?, stdSex=?, stdAdd=?, stdGrt=?, stdYear=?, classID=?, stdBD=? WHERE stdID=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, tfStdCode.getText());
                statement.setString(2, tfStdName.getText());
                statement.setString(3, tfStdSex.getText());
                statement.setString(4, tfStdAdd.getText());
                statement.setString(5, tfStdGrt.getText());
                statement.setString(6, tfStdYear.getText());
                statement.setInt(7, Integer.parseInt(tfClassID.getText()));
                statement.setString(8, tfStdBD.getText());
                statement.setInt(9, (int) tableModel.getValueAt(selectedRow, 0));
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student updated successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to update.");
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
                String query = "DELETE FROM tbStudent WHERE stdID=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, (int) tableModel.getValueAt(selectedRow, 0));
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.");
        }
    }

    public static void main(String[] args) {
        new StudentViewForm();
    }
}
