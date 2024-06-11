package org.example.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DashboardForm extends javax.swing.JFrame {
    private JLabel profileLabel;  // Label to display profile image
    private JTextField jFullname; // TextField to display full name

    public DashboardForm() {
        initComponents();
    }

    private void initComponents() {
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLogout = new javax.swing.JButton();
        jFullname = new javax.swing.JTextField();
        jFullname.setEditable(false);
        jFullname.setHorizontalAlignment(javax.swing.JTextField.CENTER); // Set text alignment to center

        jUserProfile = new javax.swing.JPanel();
        jUserProfile.setBorder(new LineBorder(Color.BLUE, 2)); // Set rectangular border
        profileLabel = new JLabel(); // Initialize label for profile image

        jData = new javax.swing.JButton();
        jReport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLogout.setBackground(new java.awt.Color(255, 51, 51));
        jLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLogout.setText("Logout");

        jLogout.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Placeholder for logout action
                jLogoutActionPerformed(evt);
            }
        });
        jData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Create an instance of DataOptionsForm
                DataOptionsForm dataOptionsForm = new DataOptionsForm();

                // Make the DataOptionsForm visible
                dataOptionsForm.setVisible(true);
            }
        });
        jStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Create an instance of DataOptionsForm
                DataOptionsForm dataOptionsForm = new DataOptionsForm();

                // Make the DataOptionsForm visible
                dataOptionsForm.setVisible(true);
            }
        });
        jReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Create an instance of DataOptionsForm
                //DataOptionsForm dataOptionsForm = new DataOptionsForm();
                ReportOptionForm reportOptionForm = new ReportOptionForm();
                reportOptionForm.setVisible(true);

            }
        });

        javax.swing.GroupLayout jUserProfileLayout = new javax.swing.GroupLayout(jUserProfile);
        jUserProfile.setLayout(jUserProfileLayout);
        jUserProfileLayout.setHorizontalGroup(
                jUserProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(profileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jUserProfileLayout.setVerticalGroup(
                jUserProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(profileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(92, Short.MAX_VALUE)
                                .addComponent(jLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jUserProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jUserProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLogout)
                                .addGap(14, 14, 14))
        );

        jData.setBackground(new java.awt.Color(0, 0, 255));
        jData.setForeground(new java.awt.Color(255, 255, 255));
        jData.setText("Data");

        jReport.setBackground(new java.awt.Color(0, 0, 255));
        jReport.setForeground(new java.awt.Color(255, 255, 255));
        jReport.setText("Report");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24));
        jLabel2.setText("Choose your options");

        jStudent.setBackground(new java.awt.Color(0, 0, 255));
        jStudent.setForeground(new java.awt.Color(255, 255, 255));
        jStudent.setText("Student");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jReport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel2)
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jReport, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }

    public void setUserDetails(String fullName, InputStream profileInputStream) {
        // Set text to uppercase
        jFullname.setText(fullName.toUpperCase());

        // Set font to bold
        Font boldFont = new Font(jFullname.getFont().getName(), Font.BOLD, jFullname.getFont().getSize());
        jFullname.setFont(boldFont);

        try {
            Image profileImage = ImageIO.read(profileInputStream);
            if (profileImage != null) {
                ImageIcon profileIcon = new ImageIcon(profileImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                profileLabel.setIcon(profileIcon); // Set profile image
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add custom logout action listener
    public void addLogoutButtonListener(ActionListener listener) {
        jLogout.addActionListener(listener);
    }

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        // Logout action placeholder
    }

    // Variables declaration
    private javax.swing.JButton jData;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jReport;
    private javax.swing.JButton jStudent;
    private javax.swing.JPanel jUserProfile;
}