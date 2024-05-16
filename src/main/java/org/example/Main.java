package org.example;

import org.example.controller.UserController;
import org.example.repository.UserRepository;
import org.example.view.SignInForm;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SignInForm signInForm = new SignInForm();
                UserRepository userRepository = new UserRepository();
                UserController controller = new UserController(signInForm, userRepository);

                signInForm.setVisible(true);
            }
        });
    }
}
