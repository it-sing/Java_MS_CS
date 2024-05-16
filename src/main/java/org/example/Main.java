package org.example;

import javax.swing.SwingUtilities;
import org.example.controller.UserController;
import org.example.repository.UserRepository;
import org.example.view.SignInForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignInForm signInForm = new SignInForm();
            UserRepository userRepository = new UserRepository();
            UserController controller = new UserController(signInForm, userRepository);

            signInForm.setVisible(true);
        });
    }
}
