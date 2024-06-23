package org.example.controller;

import org.example.model.UserDetails;
import org.example.model.UserRole;
import org.example.model.UserSignIn;
import org.example.model.UserSignUp;
import org.example.repository.UserRepository;
import org.example.security.AuthService;
import org.example.util.Message;
import org.example.view.DashboardForm;
import org.example.view.SignInForm;
import org.example.view.SignUpForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserController {
    private final SignInForm signInForm;
    private final SignUpForm signUpForm;
    private final UserRepository userRepository;
    private DashboardForm dashboardForm;

    public UserController(SignInForm signInForm, SignUpForm signUpForm, UserRepository userRepository) {
        this.signInForm = signInForm;
        this.signUpForm = signUpForm;
        this.userRepository = userRepository;

        this.signInForm.addSignInButtonListener(new LoginButtonListener());
        this.signInForm.addSignUpButtonListener(new RegisterButtonListener());
        this.signUpForm.addSignUpButtonListener(new SignUpButtonListener());
        this.signUpForm.addChooseFileButtonListener(new ChooseFileButtonListener());
    }

    class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = signInForm.getUsername();
            String password = signInForm.getPassword();

            UserSignIn userSignIn = new UserSignIn(username, password);
            if (userRepository.validateUser(userSignIn)) {
                UserDetails userDetails = userRepository.getUserDetails(username);
                if (userDetails != null) {
                    // Check permissions based on role
                    if (AuthService.hasRole(UserRole.USER, userDetails)) {
                        // User-specific actions
                        handleUserActions(userDetails);
                    }
                    else if (AuthService.hasRole(UserRole.STAFF, userDetails)) {
                        // Admin-specific actions
                        handleStaffActions(userDetails);
                    }else if (AuthService.hasRole(UserRole.ADMIN, userDetails)) {
                        // Admin-specific actions
                        handleAdminActions(userDetails);
                    } else {
                        // Handle unauthorized access
                        Message.showErrorMessage(signInForm, "Unauthorized access");
                    }
                } else {
                    Message.showErrorMessage(signInForm, "Failed to fetch user details");
                }
            } else {
                Message.showErrorMessage(signInForm, "Invalid username or password");
            }
        }


        private void handleUserActions(UserDetails userDetails) {
            // Implement actions for regular users
            Message.showSuccessMessage(signInForm, "Login successful as USER");
            // Example: Show user dashboard
            if (dashboardForm == null) {
                dashboardForm = new DashboardForm();
            }
            dashboardForm.setUserDetails(userDetails.getFullName(), userDetails.getProfileInputStream());
            dashboardForm.addLogoutButtonListener(new LogoutButtonListener());
            dashboardForm.setVisible(true);
            signInForm.dispose();
        }
        private void handleStaffActions(UserDetails userDetails) {
            // Implement actions for regular users
            if (dashboardForm == null) {
                dashboardForm = new DashboardForm();
            }
            dashboardForm.setUserDetails(userDetails.getFullName(), userDetails.getProfileInputStream());
            dashboardForm.addLogoutButtonListener(new LogoutButtonListener());
            dashboardForm.setVisible(true);
            signInForm.dispose();
        }

        private void handleAdminActions(UserDetails userDetails) {
            // Implement actions for admins
            Message.showSuccessMessage(signInForm, "Login successful as ADMIN");
            // Example: Show admin dashboard with additional features
            if (dashboardForm == null) {
                dashboardForm = new DashboardForm();
            }
            dashboardForm.setUserDetails(userDetails.getFullName(), userDetails.getProfileInputStream());
            dashboardForm.addLogoutButtonListener(new LogoutButtonListener());
            dashboardForm.setVisible(true);
            signInForm.dispose();
        }
    }

    class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            signUpForm.setVisible(true);
            signInForm.setVisible(false);
        }
    }

    class SignUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Retrieve user input from the sign-up form
            String fullName = signUpForm.getFullName();
            String username = signUpForm.getUsername();
            String password = signUpForm.getPassword();
            File profileImage = signUpForm.getProfileImage();

            // Check if a profile image is selected
            if (profileImage != null) {
                // Create a UserSignUp object with the retrieved information
                UserSignUp userSignUp = new UserSignUp(fullName, username, password, profileImage.getAbsolutePath());

                // Attempt to register the user using the userRepository
                if (userRepository.registerUser(userSignUp)) {
                    // If registration is successful, show success message
                    Message.showSuccessMessage(signUpForm, "Sign up successful");

                    // Hide the sign-up form and show the sign-in form
                    signUpForm.setVisible(false);
                    signInForm.setVisible(true);
                } else {
                    // If registration fails, show error message indicating duplicate username/password
                    Message.showErrorMessage(signUpForm, "Username already in use");
                }
            } else {
                // If no profile image is selected, show error message
                Message.showErrorMessage(signUpForm, "Please choose a profile image");
            }
        }
    }

    class ChooseFileButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                signUpForm.setSelectedFile(selectedFile);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getPath()).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
                signUpForm.setProfileImageIcon(imageIcon);
            }
        }
    }

    class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(dashboardForm, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                if (dashboardForm != null) {
                    dashboardForm.dispose();
                }
                signInForm.setVisible(true);
            }
        }
    }
}
