/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import org.example.controller.DataController;
import org.example.model.DataY1;
import org.example.model.DataY2;
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
public class DataYear2 extends javax.swing.JFrame {

    private  DataController dataController;
    /**
     * Creates new form DataYear1
     */
    public DataYear2() {
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
            jYear1.setText(getStringValue(model.getValueAt(selectedRowIndex, 3)));
            jSemester1.setText(getStringValue(model.getValueAt(selectedRowIndex, 4)));
            jDataCom.setText(getStringValue(model.getValueAt(selectedRowIndex, 5)));
            jEnglish.setText(getStringValue(model.getValueAt(selectedRowIndex, 6)));
            jDataStructure.setText(getStringValue(model.getValueAt(selectedRowIndex, 7)));
            jCPlus.setText(getStringValue(model.getValueAt(selectedRowIndex, 8)));
            jArchitecture.setText(getStringValue(model.getValueAt(selectedRowIndex, 9)));
            jDatabase.setText(getStringValue(model.getValueAt(selectedRowIndex, 10)));
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
        jYear1.setText("");
        jSemester1.setText("");
        jDataCom.setText("");
        jEnglish.setText("");
        jDataStructure.setText("");
        jCPlus.setText("");
        jArchitecture.setText("");
        jDatabase.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jDataCom = new javax.swing.JTextField();
        jStucode = new javax.swing.JTextField();
        jStucode.setEditable(false);
        jName = new javax.swing.JTextField();
        jName.setEditable(false);
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jEnglish = new javax.swing.JTextField();
        jDataStructure = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDatabase = new javax.swing.JTextField();
        jCPlus = new javax.swing.JTextField();
        jArchitecture = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDelete = new javax.swing.JButton();
        jSave = new javax.swing.JButton();
        jYear1 = new javax.swing.JTextField();
        jYear1.setEditable(false);
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jYearFeild = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSemester1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSemester = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jYears2.setBackground(java.awt.Color.orange);
        jYears2.setForeground(new java.awt.Color(255, 255, 255));
        jYears2.setText("Year 2");
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
                "Stu Code", "Name", "Gender", "Year", "Semester", "Data Com", "English", "Data Structure", "C++", "Architecute", "Database"
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

        jLabel9.setText("Data Com :");

        jLabel10.setText("Data Structure :");

        jLabel11.setText("C++ :");

        jLabel12.setText("Architecture :");

        jLabel13.setText("Database :");

        jDelete.setBackground(new java.awt.Color(255, 0, 0));
        jDelete.setForeground(new java.awt.Color(255, 255, 255));
        jDelete.setText("Delte");
        jDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jSave.setBackground(new java.awt.Color(0, 0, 255));
        jSave.setForeground(new java.awt.Color(255, 255, 255));
        jSave.setText("Save");
        jSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jLabel14.setText("Year");

        jLabel15.setText("Year");

        jLabel17.setText("Semester");

        jLabel18.setText("Semester");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jYears2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jYearFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jGenerations, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jClass, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jStuCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(jStucode, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jDataCom, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addComponent(jDataStructure, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jCPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jSemester1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jArchitecture, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(455, 455, 455)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jShow, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jYears2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGenerations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStuCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel14)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStucode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8))
                    .addComponent(jEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jDataStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11)
                            .addComponent(jCPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jSemester1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jArchitecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(jDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jYears2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jYears2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jYears2ActionPerformed
    private void jShowActionPerformed(ActionEvent evt) {
        String stdCode = jStuCode.getText();
        String className = jClass.getText();
        String stdGrt = jGenerations.getText();
        String stdYear = jYearFeild.getText();
        String semester = jSemester.getText();

        List<DataY2> students = dataController.getStudentsY2(stdCode, className, stdGrt, stdYear, semester);

        DefaultTableModel model = (DefaultTableModel) jTableinfo.getModel();
        model.setRowCount(0);

        if (!students.isEmpty()) {
            for (DataY2 student : students) {
                Object[] row = new Object[11];

                row[0] = student.getStdCode();
                row[1] = student.getStdName();
                row[2] = student.getStdSex();
                row[3] = student.getStdYear();
                row[4] = student.getSemester();
                row[5] = student.getCommunication();
                row[6] = student.getDataStructure();
                row[7] = student.getEEnglish();
                row[8] = student.getArchitecture();
                row[9] = student.getCPlusPlus();
                row[10] = student.getDatabase();

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
            String year = jYear1.getText().trim();
            String semester = jSemester1.getText();


            // Validate and parse double values
            Double cPlus = validateAndParseDouble(jCPlus.getText(), "CPlusPlus");
            Double english = validateAndParseDouble(jEnglish.getText(), "English");
            Double dataCom = validateAndParseDouble(jDataCom.getText(), "DataCom");
            Double dataStructure = validateAndParseDouble(jDataStructure.getText(), "DataStructure");
            Double database = validateAndParseDouble(jDatabase.getText(), "Database");
            Double architecture = validateAndParseDouble(jArchitecture.getText(), "Architecture");

            // Check if any of the parsed doubles are null
            if (cPlus == null || english == null || dataCom == null || dataStructure == null || database == null || architecture == null) {
                return;
            }

            // Create a DataY1 object with the retrieved data
            DataY2 student = new DataY2();
            student.setStdCode(stuCode);
            student.setStdName(name);
            student.setStdSex(gender);
            student.setStdYear(year);
            student.setSemester(semester);
            student.setCPlusPlus(cPlus);
            student.setEEnglish(english);
            student.setCommunication(dataCom);
            student.setDataStructure(dataStructure);
            student.setDatabase(database);
            student.setArchitecture(architecture);

            // Call the insertStudentY1 method to insert the data into the database
            dataController.insertStudentY2(student);

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
            Double cPlus = validateAndParseDouble(jCPlus.getText(), "C Plus");
            Double english = validateAndParseDouble(jEnglish.getText(), "English");
            Double dataCom = validateAndParseDouble(jDataCom.getText(), "DataCom");
            Double dataStructure = validateAndParseDouble(jDataStructure.getText(), "DataStructure");
            Double database = validateAndParseDouble(jDatabase.getText(), "Database");
            Double architecture = validateAndParseDouble(jArchitecture.getText(), "Architecture");

            // Check if any of the parsed doubles are null
            if (cPlus == null || english == null || dataCom == null || dataStructure == null || database == null || architecture == null) {
                return;
            }

            DataY2 student = new DataY2();
            student.setStdCode(stuCode);
            student.setStdName(name);
            student.setStdSex(gender);
            student.setStdYear(year);
            student.setSemester(semester);
            student.setCPlusPlus(cPlus);
            student.setEEnglish(english);
            student.setCommunication(dataCom);
            student.setDataStructure(dataStructure);
            student.setDatabase(database);
            student.setArchitecture(architecture);

            dataController.updateStudentY2(student);

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

            // Confirm deletion
            boolean confirm = Message.showConfirmMessage("Are you sure you want to delete the student with code: " + stuCode + "?");

            if (confirm) {
                // Call the deleteStudentY2 method to delete the data from the database
                dataController.DeleteStudentY2(stuCode, semester);

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
            java.util.logging.Logger.getLogger(DataYear2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataYear2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataYear2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataYear2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new DataYear2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jArchitecture;
    private javax.swing.JTextField jCPlus;
    private javax.swing.JTextField jClass;
    private javax.swing.JTextField jDataCom;
    private javax.swing.JTextField jDataStructure;
    private javax.swing.JTextField jDatabase;
    private javax.swing.JButton jDelete;
    private javax.swing.JTextField jEnglish;
    private javax.swing.JButton jExit;
    private javax.swing.JTextField jGender;
    private javax.swing.JTextField jGenerations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jName;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSemester;
    private javax.swing.JTextField jSemester1;
    private javax.swing.JButton jShow;
    private javax.swing.JTextField jStuCode;
    private javax.swing.JTextField jStucode;
    private javax.swing.JTable jTableinfo;
    private javax.swing.JButton jUpdate;
    private javax.swing.JTextField jYear1;
    private javax.swing.JTextField jYearFeild;
    private javax.swing.JButton jYears2;
    // End of variables declaration//GEN-END:variables
}
