package org.example;

import javax.swing.SwingUtilities;

import org.example.controller.UserController;
import org.example.repository.StudentRepository;
import org.example.repository.UserRepository;
import org.example.view.SignInForm;
import org.example.view.SignUpForm;


public class Main {
    public static void main(String[] args) {
//        StudentRepository repository = new StudentRepository();
//        StudentView view = new StudentView();
        //StudentController controller = new StudentController(repository, view);
        SwingUtilities.invokeLater(() -> {
            SignInForm signInForm = new SignInForm();
            SignUpForm signUpForm = new SignUpForm();
            UserRepository userRepository = new UserRepository();
            UserController controller = new UserController(signInForm, signUpForm, userRepository);

            signInForm.setVisible(true);
        });
    }
}
