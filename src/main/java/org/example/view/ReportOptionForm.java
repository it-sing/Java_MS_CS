package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ReportOptionForm extends JFrame {

    /**
     * Creates new form DataOptionsForm
     */
    public ReportOptionForm() {
        initComponents();
        setLocationRelativeTo(null); // Center the form on the screen
    }

    private void initComponents() {
        JButton jExit = new JButton();
        JButton jYear1 = new JButton();
        JButton jYear2 = new JButton();
        JButton jYear3 = new JButton();
        JButton jYear4 = new JButton();
        JLabel jLabel1 = new JLabel();
        JLabel jImageLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report Options");

        jExit.setText("Exit");
        jExit.setBackground(new Color(225, 29, 72));
        jExit.setForeground(Color.WHITE);
        jExit.addActionListener(e -> dispose());

        jYear1.setText("Year 1");
        jYear1.setBackground(new Color(37, 99, 235));
        jYear1.setForeground(Color.WHITE);
        jYear1.addActionListener(e -> {
            dispose();
            new ReportYear1View().setVisible(true);
        });

        jYear2.setText("Year 2");
        jYear2.setBackground(new Color(37, 99, 235));
        jYear2.setForeground(Color.WHITE);
        jYear2.addActionListener(e -> {
            dispose();
            new ReportYear2View().setVisible(true);
        });

        jYear3.setText("Year 3");
        jYear3.setBackground(new Color(37, 99, 235));
        jYear3.setForeground(Color.WHITE);
        jYear3.addActionListener(e -> {
            dispose();
            new ReportYear3View().setVisible(true);
        });

        jYear4.setText("Year 4");
        jYear4.setBackground(new Color(37, 99, 235));
        jYear4.setForeground(Color.WHITE);
        jYear4.addActionListener(e -> {
            dispose();
            new ReportYear4View().setVisible(true);
        });

        jLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        jLabel1.setText("PLEASE CHOOSE YOUR OPTIONS:");

        // Load and resize the image
        ImageIcon originalIcon = new ImageIcon("D:\\9. RUPP\\Year3\\Java E7\\Java_MS_CS\\images\\report1.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        jImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jImageLabel.setIcon(scaledIcon);
        jImageLabel.setPreferredSize(new Dimension(200, 200)); // Set preferred size for the label

        // Create layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jImageLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jYear1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jYear2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jYear3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jYear4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jExit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(120, 120, 120) // Adjusted top gap
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jImageLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(50, 50, 50) // Adjusted gap between label and buttons
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jYear1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jYear2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jYear3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jYear4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50) // Adjusted gap between buttons and exit button
                                        .addComponent(jExit)))
                        .addGap(120, 120, 120) // Bottom gap to make the form centered
        );

        pack();
        setLocationRelativeTo(null); // Center the form on the screen
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ReportOptionForm().setVisible(true));
    }
}
