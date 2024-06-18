/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import org.example.controller.DataController;
import org.example.model.DataY1;
import org.example.model.DataY4;
import org.example.util.Message;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author The User
 */
public class DataYear4 extends javax.swing.JFrame {

    private  DataController dataController;
    /**
     * Creates new form DataYear1
     */
    public DataYear4() {
        dataController = new DataController();
        initComponents();
    }
    private void jTableinfoMouseClicked(MouseEvent evt) {
        int selectedRowIndex = jTableinfo.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableinfo.getModel();

        // Check if selectedRowIndex is valid
        if (selectedRowIndex >= 0 && selectedRowIndex < jTableinfo.getRowCount()) {
            // Retrieve data from the model and populate fields
            jStucode.setText(getStringValue(model.getValueAt(selectedRowIndex, 0)));
            jName.setText(getStringValue(model.getValueAt(selectedRowIndex, 1)));
            jGender.setText(getStringValue(model.getValueAt(selectedRowIndex, 2)));
            jYearFeild.setText(getStringValue(model.getValueAt(selectedRowIndex, 3)));
            jSemester1.setText(getStringValue(model.getValueAt(selectedRowIndex, 4)));
            jOoapd_Prog.setText(getStringValue(model.getValueAt(selectedRowIndex, 5)));
            jWeb.setText(getStringValue(model.getValueAt(selectedRowIndex, 6)));
            jLunux.setText(getStringValue(model.getValueAt(selectedRowIndex, 7)));
            jMIS.setText(getStringValue(model.getValueAt(selectedRowIndex, 8)));
            jSE_ITPM.setText(getStringValue(model.getValueAt(selectedRowIndex, 9)));
        } else {

            clearFields();
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
        jOoapd_Prog.setText("");
        jWeb.setText("");
        jLunux.setText("");
        jMIS.setText("");
        jSE_ITPM.setText("");
    }


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
        jOoapd_Prog = new javax.swing.JTextField();
        jStucode = new javax.swing.JTextField();
        jStucode.setEditable(false);
        jName = new javax.swing.JTextField();
        jName.setEditable(false);
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jWeb = new javax.swing.JTextField();
        jLunux = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMIS = new javax.swing.JTextField();
        jSE_ITPM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jYearFeild = new javax.swing.JTextField();
        jYearFeild.setEditable(false);
        jSave = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jYear2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSemester = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSemester1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jYears2.setBackground(java.awt.Color.orange);
        jYears2.setForeground(new java.awt.Color(255, 255, 255));
        jYears2.setText("Year 4");

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
                "Stu Code", "Name", "Gender", "Year", "Semester", "OOAPD&PROG", "WEB", "Lunux", "MIS", "SE & IT PM"
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


        jLabel8.setText("WEB :");

        jLabel9.setText("OOAPD & PORG:");

        jLabel10.setText("Lunux :");

        jLabel11.setText("M.I.S :");

        jLabel12.setText("SE AND IT PM :");

        jLabel15.setText("Year");

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

        jLabel16.setText("Year");

        jLabel18.setText("Semester");

        jLabel19.setText("Semester");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jYears2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jShow, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(162, 162, 162)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 705, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jGenerations, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jClass, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jStuCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(103, 103, 103)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(67, 67, 67)
                                    .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(68, 68, 68)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSemester1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jYearFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jStucode, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMIS, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLunux, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jOoapd_Prog, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSE_ITPM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jYears2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jGenerations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(jSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jStuCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jOoapd_Prog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jStucode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel10))))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLunux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jYearFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMIS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSemester1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSE_ITPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jShowActionPerformed(ActionEvent evt) {
        // Retrieve input values from UI components
        String stdCode = jStuCode.getText().trim();
        String className = jClass.getText().trim();
        String stdGrt = jGenerations.getText().trim();
        String stdYear = jYear2.getText().trim();
        String semester = jSemester.getText().trim();

        // Retrieve students from the data controller based on the provided criteria
        List<DataY4> students = dataController.getStudentsY4(stdCode, className, stdGrt, stdYear, semester);

        // Get the table model to display the students' data
        DefaultTableModel model = (DefaultTableModel) jTableinfo.getModel();
        model.setRowCount(0); // Clear the existing rows from the table

        // Populate the table with retrieved student data or show a message if no students found
        if (!students.isEmpty()) {
            for (DataY4 student : students) {
                Object[] row = new Object[11]; // Adjusted to match the number of columns in Year 2

                row[0] = student.getStdCode();
                row[1] = student.getStdName();
                row[2] = student.getStdSex();
                row[3] = student.getStdYear();
                row[4] = student.getSemester(); // Include semester field
                row[5] = student.getOoAD();
                row[6] = student.getWebDev();
                row[7] = student.getLinux();
                row[8] = student.getMis();
                row[9] = student.getsE_IT_PM();

                model.addRow(row); // Add the row to the table model
            }
        } else {
            Message.showInfoMessage("No students found."); // Display a message if no students match the criteria
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

            // Validate and parse double values
            Double linux = validateAndParseDouble(jLunux.getText(), "Linux");
            Double web = validateAndParseDouble(jWeb.getText(), "Web");
            Double mis = validateAndParseDouble(jMIS.getText(), "MIS");
            Double ooapd = validateAndParseDouble(jOoapd_Prog.getText(), "OOAD");
            Double se = validateAndParseDouble(jSE_ITPM.getText(), "SE_IT_PM");

            // Check if any of the parsed doubles are null
            if (linux == null || web == null || mis == null || ooapd == null || se == null) {
                return;
            }

            // Create a DataY4 object with the retrieved data
            DataY4 student = new DataY4();
            student.setStdCode(stuCode);
            student.setStdName(name);
            student.setStdSex(gender);
            student.setStdYear(year);
            student.setSemester(semester);
            student.setLinux(linux);
            student.setWebDev(web);
            student.setMis(mis);
            student.setOoAD(ooapd);
            student.setsE_IT_PM(se);

            // Call the insertStudentY4 method to insert the data into the database
            dataController.insertStudentY4(student);

        } catch (NumberFormatException e) {
            Message.showErrorMessage("Please enter valid numbers for all numeric fields.");
        } catch (Exception e) {
            Message.showErrorMessage("An error occurred while saving the student record: " + e.getMessage());
        }
    }

    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Retrieve and validate data
            String stuCode = jStucode.getText().trim();
            String name = jName.getText().trim();
            String gender = jGender.getText().trim();
            String year = jYearFeild.getText().trim();
            String semester = jSemester1.getText().trim();

            // Validate and parse double values
            Double linux = validateAndParseDouble(jLunux.getText(), "Linux");
            Double web = validateAndParseDouble(jWeb.getText(), "Web");
            Double mis = validateAndParseDouble(jMIS.getText(), "MIS");
            Double ooapd = validateAndParseDouble(jOoapd_Prog.getText(), "OOAD");
            Double se = validateAndParseDouble(jSE_ITPM.getText(), "SE_IT_PM");

            // Check if any of the parsed doubles are null
            if (linux == null || web == null || mis == null || ooapd == null || se == null) {
                return;
            }

            // Create a DataY4 object with the retrieved data
            DataY4 student = new DataY4();
            student.setStdCode(stuCode);
            student.setStdName(name);
            student.setStdSex(gender);
            student.setStdYear(year);
            student.setSemester(semester);
            student.setLinux(linux);
            student.setWebDev(web);
            student.setMis(mis);
            student.setOoAD(ooapd);
            student.setsE_IT_PM(se);

            // Call the updateStudentY4 method to update the data in the database
            dataController.updateStudentY4(student);

        } catch (NumberFormatException e) {
            Message.showErrorMessage("Please enter valid numbers for all numeric fields.");
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

            if (stuCode.isEmpty()) {
                Message.showErrorMessage("Please enter a student code to delete.");
                return;
            }

            // Confirm deletion
            boolean confirm = Message.showConfirmMessage("Are you sure you want to delete the student with code: " + stuCode + "?");

            if (confirm) {
                // Call the deleteStudentY4 method to delete the data from the database
                dataController.deleteStudentY4(stuCode, semester);
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
            java.util.logging.Logger.getLogger(DataYear4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataYear4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataYear4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataYear4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataYear4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jClass;
    private javax.swing.JButton jDelete;
    private javax.swing.JButton jExit;
    private javax.swing.JTextField jGender;
    private javax.swing.JTextField jGenerations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLunux;
    private javax.swing.JTextField jMIS;
    private javax.swing.JTextField jName;
    private javax.swing.JTextField jOoapd_Prog;
    private javax.swing.JTextField jSE_ITPM;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSemester;
    private javax.swing.JTextField jSemester1;
    private javax.swing.JButton jShow;
    private javax.swing.JTextField jStuCode;
    private javax.swing.JTextField jStucode;
    private javax.swing.JTable jTableinfo;
    private javax.swing.JButton jUpdate;
    private javax.swing.JTextField jWeb;
    private javax.swing.JTextField jYear2;
    private javax.swing.JTextField jYearFeild;
    private javax.swing.JButton jYears2;
    // End of variables declaration//GEN-END:variables
}
