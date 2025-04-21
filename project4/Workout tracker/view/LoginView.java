package view;

import controller.UserController;
import model.User;
import model.DataManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private UserController userController;

    public LoginView() {
        userController = new UserController();

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Email and Password fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email: ");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel, BorderLayout.CENTER);

        // Add login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = userController.loginUser(email, password);
                if (user != null) {
                    // Open Dashboard if login successful
                    new DashboardView(user).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginView.this, "Invalid credentials, please try again.");
                }
            }
        });

        // Add register button action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open RegisterView for new user registration
                new RegisterView().setVisible(true);
                dispose(); // Close the login view
            }
        });
    }
}
