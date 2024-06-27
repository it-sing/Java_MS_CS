package org.example;

import javax.swing.SwingUtilities;

import org.example.controller.UserController;
import org.example.repository.UserRepository;
import org.example.view.SignInForm;
import org.example.view.SignUpForm;
import org.example.util.PropertyLoader;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Initialize UI components and repositories
            SignInForm signInForm = new SignInForm();
            SignUpForm signUpForm = new SignUpForm();
            UserRepository userRepository = new UserRepository();

            // Initialize controller and bind forms with repositories
            UserController controller = new UserController(signInForm, signUpForm, userRepository);

            // Show the sign-in form
            signInForm.setVisible(true);

//            PropertyLoader.startAutoBackup();
//            PropertyLoader.stopAutoBackup();

        });
    }
}
