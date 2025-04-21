package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private UserController userController;

    public RegisterView() {
        userController = new UserController();

        setTitle("Register");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Registration form fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email: ");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());  // Empty label for layout
        panel.add(registerButton);

        add(panel, BorderLayout.CENTER);

        // Add register button action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Call userController to register the new user
                boolean success = userController.registerUser(name, email, password);
                if (success) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Registration successful!");
                    new LoginView().setVisible(true);  // Open Login View after registration
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterView.this, "Email already in use, try another.");
                }
            }
        });
    }
}
