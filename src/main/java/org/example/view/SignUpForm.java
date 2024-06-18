package org.example.view;

import org.example.util.Rounded;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class SignUpForm extends JFrame {
    private JTextField jUsername;
    private JPasswordField jPassword;
    private JTextField jFullName;
    private Rounded jSignUpButton;
    private Rounded jChooseFileButton;
    private JLabel jImageLabel;
    private JLabel jLogoLabel;

    private File selectedFile;

    public SignUpForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setPreferredSize(new Dimension(800, 400));
        setLocationRelativeTo(null); // Center the window on screen

        // Background panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(Color.DARK_GRAY); // Set background color to dark gray

        // Title label
        JLabel titleLabel = new JLabel("SIGN UP");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(330, 40, 200, 30);
        backgroundPanel.add(titleLabel);

        // Logo label
        ImageIcon logoIcon = new ImageIcon("D:\\Rupp\\Years3\\Java\\Java_MS_CS\\src\\main\\resources//logo.png"); // Replace with your logo path
        jLogoLabel = new JLabel(logoIcon);
        jLogoLabel.setBounds(50, 40, 250, 250);
        backgroundPanel.add(jLogoLabel);

        // Sign-up panel
        JPanel signUpPanel = new JPanel();
        signUpPanel.setOpaque(false);
        signUpPanel.setLayout(null);
        signUpPanel.setBounds(350, 100, 400, 200);

        // Full Name label and text field
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setForeground(Color.WHITE);
        fullNameLabel.setBounds(20, 20, 80, 20);
        signUpPanel.add(fullNameLabel);
        jFullName = new JTextField(20);
        jFullName.setBounds(110, 20, 260, 25);
        signUpPanel.add(jFullName);

        // Username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(20, 50, 80, 20);
        signUpPanel.add(usernameLabel);
        jUsername = new JTextField(20);
        jUsername.setBounds(110, 50, 260, 25);
        signUpPanel.add(jUsername);

        // Password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(20, 80, 80, 20);
        signUpPanel.add(passwordLabel);
        jPassword = new JPasswordField(20);
        jPassword.setBounds(110, 80, 260, 25);
        signUpPanel.add(jPassword);



        // Profile Picture label and image placeholder
        JLabel profilePicLabel = new JLabel("Profile Picture:");
        profilePicLabel.setForeground(Color.WHITE);
        profilePicLabel.setBounds(20, 110, 100, 20);
        signUpPanel.add(profilePicLabel);
        jImageLabel = new JLabel();
        jImageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jImageLabel.setPreferredSize(new Dimension(100, 100));
        jImageLabel.setBounds(110, 120, 80, 80);
        signUpPanel.add(jImageLabel);

        // Choose File button
        jChooseFileButton = new Rounded("Choose File");
        jChooseFileButton.setBounds(220, 120, 120, 30);
        jChooseFileButton.setBackground(new Color(0, 123, 255));
        jChooseFileButton.setForeground(Color.WHITE);
        signUpPanel.add(jChooseFileButton);

        // Sign Up button
        jSignUpButton = new Rounded("Sign Up");
        jSignUpButton.setBounds(220, 160, 120, 30);
        jSignUpButton.setBackground(new Color(0, 123, 255));
        jSignUpButton.setForeground(Color.WHITE);
        signUpPanel.add(jSignUpButton);

        backgroundPanel.add(signUpPanel);

        getContentPane().add(backgroundPanel);
        pack();

        // Set the "Sign Up" button as the default button to be triggered when Enter is pressed
        getRootPane().setDefaultButton(jSignUpButton);
    }

    public String getFullName() {
        return jFullName.getText();
    }

    public String getUsername() {
        return jUsername.getText();
    }

    public String getPassword() {
        return new String(jPassword.getPassword());
    }

    public File getProfileImage() {
        return selectedFile;
    }

    public void addSignUpButtonListener(ActionListener listener) {
        jSignUpButton.addActionListener(listener);
    }

    public void addChooseFileButtonListener(ActionListener listener) {
        jChooseFileButton.addActionListener(listener);
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public void setProfileImageIcon(ImageIcon icon) {
        jImageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        try {
            // Use Nimbus look and feel for modern appearance
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                 | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // Run the application
        SwingUtilities.invokeLater(() -> {
            SignUpForm signUpForm = new SignUpForm();
            signUpForm.setLocationRelativeTo(null); // Center the window
            signUpForm.setVisible(true);
        });
    }

}
