package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        // Ensure frame is centered on the screen
        setLocationRelativeTo(null);


        // Background panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);

        // Welcome label
        JLabel welcomeLabel = new JLabel("WELCOME TO CS SYSTEMS");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(100, 40, 500, 30); // Adjusted bounds for proper size
        backgroundPanel.add(welcomeLabel);

        // Left-side graphic
        JLabel graphicLabel = new JLabel(new ImageIcon("D:\\Rupp\\Years3\\Java\\Java_MS_CS\\src\\main\\resources//logo.png"));
        graphicLabel.setBounds(30, 60, 400, 300);
        backgroundPanel.add(graphicLabel);

        // Sign-in panel
        JPanel signInPanel = new JPanel();
        signInPanel.setOpaque(false);
        signInPanel.setLayout(null);
        signInPanel.setBounds(450, 60, 300, 280);

        // Logo (scaled to 50x50)
        ImageIcon originalIcon = new ImageIcon("D:\\Rupp\\Years3\\Java\\Java_MS_CS\\src\\main\\resources//logo2.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setBounds(125, 10, 50, 50); // Centered in the sign-in panel
        signInPanel.add(logoLabel);

        // Sign-in label
        JLabel signInLabel = new JLabel("Sign In");
        signInLabel.setFont(new Font("Arial", Font.BOLD, 18));
        signInLabel.setForeground(Color.WHITE);
        signInLabel.setBounds(125, 70, 100, 20);
        signInPanel.add(signInLabel);

        // Username
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(20, 100, 80, 20);
        signInPanel.add(usernameLabel);
        jUsername = new JTextField(20);
        jUsername.setBounds(20, 120, 260, 25);
        signInPanel.add(jUsername);

        // Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(20, 150, 80, 20);
        signInPanel.add(passwordLabel);
        jPassword = new JPasswordField(20);
        jPassword.setBounds(20, 170, 260, 25);
        signInPanel.add(jPassword);

        // Sign In button
        jSignInButton = new Rounded("SIGN IN");
        jSignInButton.setBounds(20, 200, 120, 30);
        jSignInButton.setBackground(new Color(0, 123, 255));
        jSignInButton.setForeground(Color.WHITE);
        signInPanel.add(jSignInButton);

        // Sign Up button
        jSignUpButton = new Rounded("SIGN UP ");
        jSignUpButton.setBounds(160, 200, 120, 30);
        jSignUpButton.setBackground(new Color(0, 123, 255));
        jSignUpButton.setForeground(Color.WHITE);
        signInPanel.add(jSignUpButton);


        backgroundPanel.add(signInPanel);
        backgroundPanel.setBackground(Color.DARK_GRAY); // Set background color to dark gray

        getContentPane().add(backgroundPanel);
        pack();

        // Set the "Sign In" button as the default button to be triggered when Enter is pressed
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
            SignInForm signInForm = new SignInForm();
            signInForm.setVisible(true);
        });
    }
}

// Custom button with rounded corners
class Rounded extends JButton {
    public Rounded(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        g2.dispose();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setUI(new RoundedUI());
    }
}

class RoundedUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JButton button = (JButton) c;
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
