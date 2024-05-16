package org.example.controller;

import org.example.dto.UserSignInRequest;
import org.example.repository.UserRepository;
import org.example.util.Message;
import org.example.view.SignInForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private  final SignInForm signInForm;
    private final UserRepository userRepository;
    public UserController(SignInForm signInForm, UserRepository userRepository) {
        this.signInForm = signInForm;
        this.userRepository = userRepository;

        this.signInForm.addLoginButtonListener(new LoginButtonListener());
    }

    class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = signInForm.getUsername();
            String password = signInForm.getPassword();

            UserSignInRequest userSignInRequest = new UserSignInRequest(username, password);
            if (userRepository.validateUser(userSignInRequest)) {
                Message.showSuccessMessage(signInForm, "Login successful");

            } else {
                Message.showErrorMessage(signInForm, "Invalid username or password");
            }
        }
    }
}
