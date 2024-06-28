package org.example.view;

import org.example.controller.StudentController;
import org.example.model.UserDetails;
import org.example.model.UserPermission;
import org.example.model.UserRole;
import org.example.model.UserSession;
import org.example.security.AuthService;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DashboardForm extends JFrame {
    private JLabel profileLabel;  // Label to display profile image
    private JTextField jFullname; // TextField to display full name
    private StudentController studentController;
    private UserSession userSession;

    // Variables declaration
    private JButton jData;
    private JButton jAdmin;
    private JFileChooser jFileChooser1;
    private JLabel jLabel2;
    private JButton jLogout;
    private JPanel jPanel1;
    private JButton jReport;
    private JButton jStudent;
    private JPanel jUserProfile;

    public DashboardForm(StudentController studentController) {
        this.studentController = studentController;
        initComponents();
        initUserDetails();
    }

    private void initComponents() {
        jFileChooser1 = new JFileChooser();
        jPanel1 = new JPanel();
        jLogout = new JButton();
        jFullname = new JTextField();

        jUserProfile = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
                g2d.setClip(circle);
                g2d.setColor(getBackground());
                g2d.fill(circle);
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(2));
                g2d.draw(circle);
                g2d.dispose();
            }
        };
        profileLabel = new JLabel();
        jData = new JButton();
        jReport = new JButton();
        jLabel2 = new JLabel();
        jStudent = new JButton();
        jAdmin = new JButton(); // New button for Admin

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(60, 63, 65));
        jPanel1.setPreferredSize(new Dimension(200, 400));

        jFullname.setEditable(false);
        jFullname.setHorizontalAlignment(JTextField.CENTER);
        jFullname.setForeground(Color.WHITE);
        jFullname.setBackground(new Color(60, 63, 65));
        jFullname.setBorder(BorderFactory.createEmptyBorder());
        jFullname.setFont(new Font("Arial", Font.BOLD, 14));

        jUserProfile.setPreferredSize(new Dimension(100, 100));
        jUserProfile.setBackground(new Color(200, 200, 200));
        jUserProfile.setOpaque(false);

        profileLabel.setHorizontalAlignment(JLabel.CENTER);
        GroupLayout jUserProfileLayout = new GroupLayout(jUserProfile);
        jUserProfile.setLayout(jUserProfileLayout);
        jUserProfileLayout.setHorizontalGroup(
                jUserProfileLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(profileLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jUserProfileLayout.setVerticalGroup(
                jUserProfileLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(profileLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jLogout.setBackground(new Color(255, 51, 51));
        jLogout.setForeground(Color.WHITE);
        jLogout.setText("Logout");
        jLogout.setFocusPainted(false);
        jLogout.setBorderPainted(false);

        jLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Placeholder for logout action
                jLogoutActionPerformed((ActionListener) evt);
            }
        });

        jAdmin.setBackground(new Color(30, 144, 255));
        jAdmin.setForeground(Color.WHITE);
        jAdmin.setText("Admin");
        jAdmin.setFocusPainted(false);
        jAdmin.setBorderPainted(false);

        jAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action for Admin button
                Admin adminForm = new Admin();
                adminForm.setVisible(true);
            }
        });

        jData.setBackground(new Color(30, 144, 255));
        jData.setForeground(Color.WHITE);
        jData.setText("Data");
        jData.setFocusPainted(false);
        jData.setBorderPainted(false);

        jData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataOptionsForm dataOptionsForm = new DataOptionsForm();
                dataOptionsForm.setVisible(true);
            }
        });

        jReport.setBackground(new Color(30, 144, 255));
        jReport.setForeground(Color.WHITE);
        jReport.setText("Report");
        jReport.setFocusPainted(false);
        jReport.setBorderPainted(false);

        jReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReportOptionForm reportOptionForm = new ReportOptionForm();
                reportOptionForm.setVisible(true);
            }
        });

        jLabel2.setFont(new Font("Khmer OS", Font.BOLD, 40));
        jLabel2.setText("Welcome to CS Systems G3");
        jLabel2.setForeground(new Color(60, 63, 65));

        jStudent.setBackground(new Color(30, 144, 255));
        jStudent.setForeground(Color.WHITE);
        jStudent.setText("Student");
        jStudent.setFocusPainted(false);
        jStudent.setBorderPainted(false);

        jStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentViewForm studentViewForm = new StudentViewForm();
                studentViewForm.setVisible(true);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jUserProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jFullname)
                                        .addComponent(jLogout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jUserProfile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jFullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                .addComponent(jLogout, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jAdmin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jStudent, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jData, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jReport, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        )
                                )
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jAdmin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jStudent, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jData, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jReport, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
        );

        setPreferredSize(new Dimension(1200, 800));
        pack();
        setLocationRelativeTo(null);  // Center the form on the screen
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

    private void initUserDetails() {
        UserDetails currentUser = getCurrentUser();
        if (currentUser != null) {
            setUserDetails(currentUser.getFullName(), currentUser.getProfileInputStream());

            // Use AuthService to set button visibility based on user role
            UserRole userRole = currentUser.getRole();
            System.out.println("User Role: " + userRole); // Debugging line

            if (userRole == UserRole.USER) {
                jAdmin.setVisible(false);
                jReport.setVisible(false);
                jData.setVisible(true); // Optional: Hide additional buttons for USER
                jStudent.setVisible(true); // Optional: Hide additional buttons for USER
            }
            else if (userRole == UserRole.STAFF){
                jAdmin.setVisible(false);
                jReport.setVisible(true);
                jData.setVisible(true);
                jStudent.setVisible(true);
            }else {
                jAdmin.setVisible(true);
                jReport.setVisible(true);
                jData.setVisible(true);
                jStudent.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private UserDetails getCurrentUser() {
        UserDetails currentUser = UserSession.getInstance().getCurrentUser();

        if (currentUser != null) {
            String currentFullName = currentUser.getFullName();
            String currentUsername = currentUser.getUsername();
            UserRole userRole = currentUser.getRole();
            InputStream profileInputStream = currentUser.getProfileInputStream(); // Use updated method

            return new UserDetails(currentFullName, currentUsername, profileInputStream, userRole);
        } else {
            System.out.println("No current user in session.");
            return null;
        }
    }

    public void jLogoutActionPerformed(ActionListener listener) {
        // Clear current user session
//        UserSession.getInstance().setCurrentUser(null);

        // Remove existing listeners (your existing code)
        ActionListener[] listeners = jLogout.getActionListeners();
        for (ActionListener existingListener : listeners) {
            jLogout.removeActionListener(existingListener);
        }
        // Add the new listener
        jLogout.addActionListener(listener);
    }

}
