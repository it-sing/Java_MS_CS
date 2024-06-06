/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataOptionsForm extends javax.swing.JFrame {

    /**
     * Creates new form DataOptionsForm
     */
    public DataOptionsForm() {
        initComponents();
//        DataOptionsController controller = new DataOptionsController(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYear4 = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        jYear2 = new javax.swing.JButton();
        jYear3 = new javax.swing.JButton();
        jYear1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current form
                dispose();
            }
        });
        jYear1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                // Create an instance of DataOptionsForm
                DataYear1 dataYear1 = new DataYear1();

                dataYear1.setVisible(true);
            }
        });
        jYear2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                // Create an instance of DataOptionsForm
                DataYear2 dataYear2 = new DataYear2();

                dataYear2.setVisible(true);
            }
        });
        jYear3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                // Create an instance of DataOptionsForm
                DataYear3 dataYear3 = new DataYear3();

                dataYear3.setVisible(true);
            }
        });
        jYear4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                // Create an instance of DataOptionsForm
                DataYear4 dataYear4 = new DataYear4();

                dataYear4.setVisible(true);
            }
        });

        jYear1.setBackground(new java.awt.Color(0, 0, 255));
        jYear1.setForeground(new java.awt.Color(255, 255, 255));
        jYear1.setText("Year 1");

        jYear2.setBackground(new java.awt.Color(0, 0, 255));
        jYear2.setForeground(new java.awt.Color(255, 255, 255));
        jYear2.setText("Year 2");

        jYear3.setBackground(new java.awt.Color(0, 0, 255));
        jYear3.setForeground(new java.awt.Color(255, 255, 255));
        jYear3.setText("Year 3");
        jYear4.setBackground(new java.awt.Color(0, 0, 255));
        jYear4.setForeground(new java.awt.Color(255, 255, 255));
        jYear4.setText("Year 4");

        jExit.setBackground(new java.awt.Color(255, 0, 0));
        jExit.setForeground(new java.awt.Color(255, 255, 255));
        jExit.setText("Exit");

        jYear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jYear1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Please chose your options");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jYear3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jYear4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYear3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYear4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jExit)
                .addContainerGap())
        );

        pack();
    }

    private void jYear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jYear1ActionPerformed

    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataOptionsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataOptionsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataOptionsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataOptionsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataOptionsForm().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jYear1;
    private javax.swing.JButton jYear2;
    private javax.swing.JButton jYear3;
    private javax.swing.JButton jYear4;
    // End of variables declaration//GEN-END:variables
}