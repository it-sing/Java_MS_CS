/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import org.example.controller.DataController;
import org.example.model.DataY1;
import org.example.util.Message;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author The User
 */
public class DataYear1 extends javax.swing.JFrame {

    private  DataController dataController;
    /**
     * Creates new form DataYear1
     */
    public DataYear1() {
        dataController = new DataController();
        initComponents();
    }
    private void jTableinfoMouseClicked(MouseEvent evt) {
        int selectedRowIndex = jTableinfo.getSelectedRow();

        // Get the model from the jTableinfo
        DefaultTableModel model = (DefaultTableModel) jTableinfo.getModel();

        // Check if selectedRowIndex is valid
        if (selectedRowIndex >= 0 && selectedRowIndex < jTableinfo.getRowCount()) {
            // Retrieve data from the model and populate the fields
            jStucode.setText(getStringValue(model.getValueAt(selectedRowIndex, 0)));
            jName.setText(getStringValue(model.getValueAt(selectedRowIndex, 1)));
            jGender.setText(getStringValue(model.getValueAt(selectedRowIndex, 2)));
            jYearFeild.setText(getStringValue(model.getValueAt(selectedRowIndex, 3)));
            jSemester1.setText(getStringValue(model.getValueAt(selectedRowIndex, 4)));
            jCprogram.setText(getStringValue(model.getValueAt(selectedRowIndex, 5)));
            jEnglish.setText(getStringValue(model.getValueAt(selectedRowIndex, 6)));
            jFun.setText(getStringValue(model.getValueAt(selectedRowIndex, 7)));
            jMath.setText(getStringValue(model.getValueAt(selectedRowIndex, 8)));
            jPhysics.setText(getStringValue(model.getValueAt(selectedRowIndex, 9)));
            jCenterySkill.setText(getStringValue(model.getValueAt(selectedRowIndex, 10)));
            jHistory.setText(getStringValue(model.getValueAt(selectedRowIndex, 11)));
        } else {
            // Handle case where selected row index is invalid
            // This can happen if no row is selected or if selectedRowIndex is out of bounds
            clearFields(); // Method to clear all text fields or handle error state
        }
    }

    // Helper method to safely convert Object to String, handling null values
    private String getStringValue(Object value) {
        return (value == null) ? "" : value.toString();
    }

    // Method to clear all text fields
    private void clearFields() {
        jStucode.setText("");
        jName.setText("");
        jGender.setText("");
        jYearFeild.setText("");
        jSemester1.setText("");
        jCprogram.setText("");
        jEnglish.setText("");
        jFun.setText("");
        jMath.setText("");
        jPhysics.setText("");
        jCenterySkill.setText("");
        jHistory.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYears2 = new javax.swing.JButton();
        jClass = new javax.swing.JTextField();
        jStuCode = new javax.swing.JTextField();
        jGenerations = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableinfo = new javax.swing.JTable();
        jUpdate = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jShow = new javax.swing.JButton();
        jGender = new javax.swing.JTextField();
        jGender.setEditable(false);
        jCprogram = new javax.swing.JTextField();
        jStucode = new javax.swing.JTextField();
        jStucode.setEditable(false);
        jName = new javax.swing.JTextField();
        jName.setEditable(false);
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jEnglish = new javax.swing.JTextField();
        jFun = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jHistory = new javax.swing.JTextField();
        jMath = new javax.swing.JTextField();
        jPhysics = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCenterSkill = new javax.swing.JLabel();
        jCenterySkill = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jYear = new javax.swing.JTextField();
        jSave = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jYearFeild = new javax.swing.JTextField();
        jYearFeild.setEditable(false);
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSemester = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSemester1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jYears2.setBackground(java.awt.Color.orange);
        jYears2.setForeground(new java.awt.Color(255, 255, 255));
        jYears2.setText("Year 1");
        jYears2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jYears2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Class");

        jLabel2.setText("Stu code");

        jLabel3.setText("Generations");

        jTableinfo.setDefaultEditor(Object.class, null);
        jTableinfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTableinfoMouseClicked(evt);
            }
        });

        jTableinfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu code", "Name", "Gender","Year", "Semester", "Cprogram", "English", "Fundamental", "Math", "Physics", "CenturySkill", "History"
            }
        ));
        jScrollPane1.setViewportView(jTableinfo);

        jUpdate.setBackground(new java.awt.Color(0, 0, 255));
        jUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jUpdate.setText("Update");
        jUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateActionPerformed(evt);
            }
        });

        jExit.setBackground(new java.awt.Color(255, 0, 0));
        jExit.setForeground(new java.awt.Color(255, 255, 255));
        jExit.setText("Exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current form
                dispose();

                // Open the DataOptionsForm
                DataOptionsForm dataOptionsForm = new DataOptionsForm();
                dataOptionsForm.setVisible(true); // Assuming DataOptionsForm extends JFrame, set it visible
            }
        });



        jShow.setBackground(new java.awt.Color(0, 0, 255));
        jShow.setForeground(new java.awt.Color(255, 255, 255));
        jShow.setText("Show");
        jShow.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowActionPerformed(evt);
            }
        });

        jLabel5.setText("StuCode :");

        jLabel6.setText("Name :");

        jLabel7.setText("Gender :");


        jLabel8.setText("English :");

        jLabel9.setText("CProgram :");

        jLabel10.setText("Fundamental :");

        jLabel11.setText("Math :");

        jLabel12.setText("Physics :");

        jLabel13.setText("History :");

        jCenterSkill.setText("CenterySkill :");

        jLabel4.setText("Year");

        jSave.setBackground(new java.awt.Color(0, 0, 255));
        jSave.setForeground(new java.awt.Color(255, 255, 255));
        jSave.setText("Save");
        jSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jDelete.setBackground(new java.awt.Color(255, 0, 0));
        jDelete.setForeground(new java.awt.Color(255, 255, 255));
        jDelete.setText("Delte");
        jDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jLabel14.setText("Year");

        jLabel16.setText("Semester");

        jLabel17.setText("Semester");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jYears2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jGenerations, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(80, 80, 80)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(jFun, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(jShow, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(59, 59, 59)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSemester1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jYearFeild))
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(jMath, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(jPhysics, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(65, 65, 65)
                                        .addComponent(jStucode, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jCprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jCenterSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCenterySkill, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jClass, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStuCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jYears2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jGenerations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jStuCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jStucode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCprogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCenterSkill)
                        .addComponent(jCenterySkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jYearFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSemester1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPhysics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel12))))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jShow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jYears2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jYears2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jYears2ActionPerformed


    private void jShowActionPerformed(ActionEvent evt) {
        String stdCode = jStuCode.getText();
        String className = jClass.getText();
        String stdGrt = jGenerations.getText();
        String stdYear = jYear.getText();
        String semester = jSemester.getText();

        List<DataY1> students = dataController.getStudentsY1(stdCode, className, stdGrt, stdYear, semester);

        DefaultTableModel model = (DefaultTableModel) jTableinfo.getModel();
        model.setRowCount(0); // Clear the existing rows from the table

        if (!students.isEmpty()) {
            for (DataY1 student : students) {
                Object[] row = new Object[12];

                row[0] = student.getStdCode();
                row[1] = student.getStdName();
                row[2] = student.getStdSex();
                row[3] = student.getStdYear();
                row[4] = student.getSemester();
                row[5] = student.getCProgram();
                row[6] = student.getEnglish();
                row[7] = student.getFundamental();
                row[8] = student.getMath();
                row[9] = student.getPhysics();
                row[10] = student.getCenturySkill();
                row[11] = student.getHistory();

                model.addRow(row);
            }
        } else {
            Message.showInfoMessage("No students found.");
        }
    }
    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Retrieve and validate data
            String stuCode = jStucode.getText().trim();
            String name = jName.getText().trim();
            String gender = jGender.getText().trim();
            String year = jYearFeild.getText().trim();
            String semester = jSemester1.getText().trim();

            Double cProgram = validateAndParseDouble(jCprogram.getText(), "C Program");
            Double english = validateAndParseDouble(jEnglish.getText(), "English");
            Double fun = validateAndParseDouble(jFun.getText(), "Fundamental");
            Double math = validateAndParseDouble(jMath.getText(), "Math");
            Double physics = validateAndParseDouble(jPhysics.getText(), "Physics");
            Double centerySkill = validateAndParseDouble(jCenterySkill.getText(), "Century Skill");
            Double history = validateAndParseDouble(jHistory.getText(), "History");

            if (cProgram == null || english == null || fun == null || math == null || physics == null || centerySkill == null || history == null) {
                return;
            }

            // Create a DataY1 object with the retrieved data
            DataY1 student = new DataY1();
            student.setStdCode(stuCode);
            student.setStdName(name);
            student.setStdSex(gender);
            student.setStdYear(year);
            student.setSemester(semester);
            student.setCProgram(cProgram);
            student.setEnglish(english);
            student.setFundamental(fun);
            student.setMath(math);
            student.setPhysics(physics);
            student.setCenturySkill(centerySkill);
            student.setHistory(history);

            // Call the insertStudentY1 method to insert the data into the database
            dataController.insertStudentY1(student);

        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while saving the student record: " + e.getMessage());
        }
    }
    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String stuCode = jStucode.getText().trim();
            String name = jName.getText().trim();
            String gender = jGender.getText().trim();
            String year = jYearFeild.getText().trim();
            String semester = jSemester1.getText().trim();

            if (stuCode.isEmpty() || name.isEmpty() || gender.isEmpty() || year.isEmpty()) {
                Message.showErrorMessage("Please fill in all fields.");
                return;
            }

            Double cProgram = validateAndParseDouble(jCprogram.getText(), "C Program");
            Double english = validateAndParseDouble(jEnglish.getText(), "English");
            Double fun = validateAndParseDouble(jFun.getText(), "Fundamental");
            Double math = validateAndParseDouble(jMath.getText(), "Math");
            Double physics = validateAndParseDouble(jPhysics.getText(), "Physics");
            Double centerySkill = validateAndParseDouble(jCenterySkill.getText(), "Century Skill");
            Double history = validateAndParseDouble(jHistory.getText(), "History");

            if (cProgram == null || english == null || fun == null || math == null || physics == null || centerySkill == null || history == null) {
                return;
            }

            DataY1 student = new DataY1();
            student.setStdCode(stuCode);
            student.setStdName(name);
            student.setStdSex(gender);
            student.setStdYear(year);
            student.setSemester(semester);
            student.setCProgram(cProgram);
            student.setEnglish(english);
            student.setFundamental(fun);
            student.setMath(math);
            student.setPhysics(physics);
            student.setCenturySkill(centerySkill);
            student.setHistory(history);

            dataController.updateStudentY1(student);
        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while updating the student record: " + e.getMessage());
        }
    }

    private Double validateAndParseDouble(String text, String fieldName) {
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            Message.showErrorMessage("Please enter a valid number for " + fieldName + ".");
            return null;
        }
    }
    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String stuCode = jStucode.getText().trim();
            String semester = jSemester1.getText().trim();

            boolean confirm = Message.showConfirmMessage("Are you sure you want to delete the student with code: " + stuCode + "?");

            if (confirm) {
                // Call the deleteStudentY1 method to delete the data from the database
                dataController.DeleteStudentY1(stuCode, semester);

                // Notify the user of a successful delete
                Message.showInfoMessage("Student record deleted successfully.");
            }

        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while deleting the student record: " + e.getMessage());
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataYear1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jCenterSkill;
    private javax.swing.JTextField jCenterySkill;
    private javax.swing.JTextField jClass;
    private javax.swing.JTextField jCprogram;
    private javax.swing.JButton jDelete;
    private javax.swing.JTextField jEnglish;
    private javax.swing.JButton jExit;
    private javax.swing.JTextField jFun;
    private javax.swing.JTextField jGender;
    private javax.swing.JTextField jGenerations;
    private javax.swing.JTextField jHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMath;
    private javax.swing.JTextField jName;
    private javax.swing.JTextField jPhysics;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSemester;
    private javax.swing.JTextField jSemester1;
    private javax.swing.JButton jShow;
    private javax.swing.JTextField jStuCode;
    private javax.swing.JTextField jStucode;
    private javax.swing.JTable jTableinfo;
    private javax.swing.JButton jUpdate;
    private javax.swing.JTextField jYear;
    private javax.swing.JTextField jYearFeild;
    private javax.swing.JButton jYears2;
    // End of variables declaration//GEN-END:variables
}
