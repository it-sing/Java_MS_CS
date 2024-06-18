package org.example.view;

import org.example.util.Rounded;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class SignInForm extends JFrame {

    private JTextField jUsername;
    private JPasswordField jPassword;
    private Rounded jSignInButton;
    private Rounded jSignUpButton;
    private JLabel jForgotPassword;

    public SignInForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sign In");
        setPreferredSize(new Dimension(800, 400));
        setLocationRelativeTo(null);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);

        JLabel welcomeLabel = new JLabel("WELCOME TO CS SYSTEMS");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(100, 40, 500, 30);
        backgroundPanel.add(welcomeLabel);

        JLabel graphicLabel = new JLabel(new ImageIcon("D:\\Rupp\\Years3\\Java\\Java_MS_CS\\src\\main\\resources//logo.png"));
        graphicLabel.setBounds(30, 60, 400, 300);
        backgroundPanel.add(graphicLabel);

        JPanel signInPanel = new JPanel();
        signInPanel.setOpaque(false);
        signInPanel.setLayout(null);
        signInPanel.setBounds(450, 60, 300, 280);

        ImageIcon originalIcon = new ImageIcon("D:\\Rupp\\Years3\\Java\\Java_MS_CS\\src\\main\\resources//logo2.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBounds(125, 10, 50, 50);
        signInPanel.add(logoLabel);

        JLabel signInLabel = new JLabel("Sign In");
        signInLabel.setFont(new Font("Arial", Font.BOLD, 18));
        signInLabel.setForeground(Color.WHITE);
        signInLabel.setBounds(125, 70, 100, 20);
        signInPanel.add(signInLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(20, 100, 80, 20);
        signInPanel.add(usernameLabel);
        jUsername = new JTextField(20);
        jUsername.setBounds(20, 120, 260, 25);
        signInPanel.add(jUsername);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(20, 150, 80, 20);
        signInPanel.add(passwordLabel);
        jPassword = new JPasswordField(20);
        jPassword.setBounds(20, 170, 260, 25);
        signInPanel.add(jPassword);

        jSignInButton = new Rounded("SIGN IN");
        jSignInButton.setBounds(20, 200, 120, 30);
        jSignInButton.setBackground(new Color(0, 123, 255));
        jSignInButton.setForeground(Color.WHITE);
        signInPanel.add(jSignInButton);

        jSignUpButton = new Rounded("SIGN UP");
        jSignUpButton.setBounds(160, 200, 120, 30);
        jSignUpButton.setBackground(new Color(0, 123, 255));
        jSignUpButton.setForeground(Color.WHITE);
        signInPanel.add(jSignUpButton);

        backgroundPanel.add(signInPanel);
        backgroundPanel.setBackground(Color.DARK_GRAY);
        getContentPane().add(backgroundPanel);
        pack();

        getRootPane().setDefaultButton(jSignInButton);
    }

    public String getUsername() {
        return jUsername.getText();
    }

    public String getPassword() {
        return new String(jPassword.getPassword());
    }

    public void addSignInButtonListener(ActionListener listener) {
        jSignInButton.addActionListener(listener);
    }

    public void addSignUpButtonListener(ActionListener listener) {
        jSignUpButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            SignInForm signInForm = new SignInForm();
            signInForm.setVisible(true);
        });
    }
}
