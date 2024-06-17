package org.example;

import javax.swing.SwingUtilities;

import org.example.controller.DataController;
import org.example.controller.UserController;
import org.example.model.DataY1;
import org.example.repository.DataRepository;
import org.example.repository.UserRepository;
import org.example.view.SignInForm;
import org.example.view.SignUpForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignInForm signInForm = new SignInForm();
            SignUpForm signUpForm = new SignUpForm();
            UserRepository userRepository = new UserRepository();
            UserController controller = new UserController(signInForm, signUpForm, userRepository);
            signInForm.setVisible(true);

        });
    }
}
