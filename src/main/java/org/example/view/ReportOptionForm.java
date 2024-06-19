package org.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportOptionForm extends javax.swing.JFrame {

    /**
     * Creates new form DataOptionsForm
     */
    public ReportOptionForm() {
        initComponents();
        setLocationRelativeTo(null); // Center the form on the screen
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton jYear4 = new javax.swing.JButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JButton jExit = new javax.swing.JButton();
        javax.swing.JButton jYear2 = new javax.swing.JButton();
        javax.swing.JButton jYear3 = new javax.swing.JButton();
        javax.swing.JButton jYear1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current form
                dispose();
            }
        });

        jYear1.addActionListener(e -> {
            dispose();
            ReportYear1View reportYear1 = new ReportYear1View();
            reportYear1.setVisible(true);
        });

        jYear2.addActionListener(e -> {
            dispose();
            ReportYear2View reportYear2View = new ReportYear2View();
            reportYear2View.setVisible(true);
        });

        jYear3.addActionListener(e -> {
            dispose();
            ReportYear3View reportYear3View = new ReportYear3View();
            reportYear3View.setVisible(true);
        });

        jYear4.addActionListener(e -> {
            dispose();
            ReportYear4View reportYear4View = new ReportYear4View();
            reportYear4View.setVisible(true);
        });

        jYear1.setBackground(new java.awt.Color(37, 99, 235));
        jYear1.setForeground(new java.awt.Color(255, 255, 255));
        jYear1.setText("Year 1");

        jYear2.setBackground(new java.awt.Color(37, 99, 235));
        jYear2.setForeground(new java.awt.Color(255, 255, 255));
        jYear2.setText("Year 2");

        jYear3.setBackground(new java.awt.Color(37, 99, 235));
        jYear3.setForeground(new java.awt.Color(255, 255, 255));
        jYear3.setText("Year 3");

        jYear4.setBackground(new java.awt.Color(37, 99, 235));
        jYear4.setForeground(new java.awt.Color(255, 255, 255));
        jYear4.setText("Year 4");

        jExit.setBackground(new java.awt.Color(225, 29, 72));
        jExit.setForeground(new java.awt.Color(255, 255, 255));
        jExit.setText("Exit");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Please choose your options:".toUpperCase());

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
        setLocationRelativeTo(null); // Center the form on the screen
    }


    // End of variables declaration//GEN-END:variables
}
