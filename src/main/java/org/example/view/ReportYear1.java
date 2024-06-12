package org.example.view;

import org.example.controller.DataController;
import org.example.model.DataY1;
import org.example.util.Message;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * ReportYear1 JFrame for displaying student data in a table.
 */
public class ReportYear1 extends javax.swing.JFrame {

    private DataController dataController;

    public ReportYear1() {
        initComponents();
        dataController = new DataController();
        setupListeners();
    }

    private void setupListeners() {
        jTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTableinfoMouseClicked(evt);
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loadTableData(evt);
            }
        });
    }

    private void jTableinfoMouseClicked(MouseEvent evt) {
        int selectedRowIndex = jTable2.getSelectedRow();

        // Get the model from the jTableinfo
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        // Retrieve data from the selected row and populate the fields
        jTextField1.setText(model.getValueAt(selectedRowIndex, 1).toString());
        jTextField2.setText(model.getValueAt(selectedRowIndex, 2).toString());
        jTextField3.setText(model.getValueAt(selectedRowIndex, 3).toString());
        // Add similar lines for other text fields if needed
    }

    private void loadTableData(ActionEvent evt) {
        String name = jTextField1.getText();
        String generation = jTextField2.getText();
        String className = jTextField3.getText();

        List<DataY1> students = dataController.getStudentsY1(name, className, generation, "Year1");

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Clear existing data

        for (DataY1 student : students) {
            model.addRow(new Object[]{
                    student.getStdCode(),
                    student.getStdName(),
                    student.getStdSex(),
                    student.getCProgram(),
                    student.getEnglish(),
                    student.getFundamental(),
                    student.getMath(),
                    student.getPhysics(),
                    student.getHistory()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        showButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Name");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Year1");

        jLabel3.setText("Generation");

        jLabel4.setText("Class");


        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"Id", "Name", "Gender", "C Programming", "English", "Fundamental", "Math", "Physics", "History"}
                },
                new String [] {
                        "Id", "Name", "Gender", "C Programming", "English", "Fundamental", "Math", "Physics", "History"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton2ActionPerformed(evt);
                jShowActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");

        jButton4.setText("Excel");

        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addGap(180, 180, 180)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(64, 64, 64)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(85, 85, 85)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(126, 126, 126)
                                                                .addComponent(showButton))
                                                        .addComponent(jScrollPane2))
                                                .addContainerGap(72, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton4)
                                                .addGap(26, 26, 26)
                                                .addComponent(jButton2)
                                                .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showButton))
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jShowActionPerformed(ActionEvent evt) {
        JTextField jStuCode = null;
        JTextField jClass = null;
        JTextField jGenerations = null;
        JTextField jYear = null;
        String stdCode = jStuCode.getText();
        String className = jClass.getText();
        String stdGrt = jGenerations.getText();
        String stdYear = jYear.getText();

        List<DataY1> students = dataController.getStudentsY1(stdCode, className, stdGrt, stdYear);

        AbstractButton jTableinfo = null;
        DefaultTableModel model = (DefaultTableModel) jTableinfo.getModel();
        model.setRowCount(0); // Clear the existing rows from the table

        if (!students.isEmpty()) {
            for (DataY1 student : students) {
                Object[] row = new Object[11];

                row[0] = student.getStdCode();
                row[1] = student.getStdName();
                row[2] = student.getStdSex();
                row[3] = student.getStdYear();
                row[4] = student.getCProgram();
                row[5] = student.getEnglish();
                row[6] = student.getFundamental();
                row[7] = student.getMath();
                row[8] = student.getPhysics();
                row[9] = student.getCenturySkill();
                row[10] = student.getHistory();

                model.addRow(row);
            }
        } else {
            Message.showInfoMessage("No students found.");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //GEN-FIRST:event_jButton2ActionPerformed
        // Handle PDF button action here
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Main method to run the JFrame.
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
            java.util.logging.Logger.getLogger(ReportYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportYear1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportYear1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton showButton;
    private javax.swing.JTable jTableinfo;
    // End of variables declaration//GEN-END:variables
}
