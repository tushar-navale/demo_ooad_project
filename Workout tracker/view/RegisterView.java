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

        setTitle("FitLife");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create main panel with gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(45, 45, 45);    // Dark charcoal
                Color color2 = new Color(240, 240, 240); // Light gray/almost white
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        // Create register panel with white background and shadow effect
        JPanel registerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        registerPanel.setLayout(new GridBagLayout());
        registerPanel.setPreferredSize(new Dimension(400, 500));
        registerPanel.setOpaque(false);

        // Add components with GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Title
        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerPanel.add(titleLabel, gbc);

        // Name field
        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300, 35));
        registerPanel.add(nameLabel, gbc);
        registerPanel.add(nameField, gbc);

        // Email field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 35));
        registerPanel.add(emailLabel, gbc);
        registerPanel.add(emailField, gbc);

        // Password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 35));
        registerPanel.add(passwordLabel, gbc);
        registerPanel.add(passwordField, gbc);

        // Register button
        JButton registerButton = new JButton("Create Account");
        JButton backToLoginButton = new JButton("Back to Login");

        // Style buttons
        registerButton.setPreferredSize(new Dimension(300, 40));
        backToLoginButton.setPreferredSize(new Dimension(300, 40));

        // Update button colors to match theme
        registerButton.setBackground(new Color(45, 45, 45));
        backToLoginButton.setBackground(new Color(100, 100, 100));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);

        backToLoginButton.setBackground(new Color(189, 195, 199));
        backToLoginButton.setForeground(Color.WHITE);
        backToLoginButton.setFocusPainted(false);
        backToLoginButton.setBorderPainted(false);

        gbc.insets = new Insets(20, 30, 10, 30);
        registerPanel.add(registerButton, gbc);
        gbc.insets = new Insets(10, 30, 20, 30);
        registerPanel.add(backToLoginButton, gbc);

        mainPanel.add(registerPanel);
        add(mainPanel);

        // Register button action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                boolean success = userController.registerUser(name, email, password);
                if (success) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Registration successful!");
                    new LoginView().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterView.this, "Email already in use, try another.");
                }
            }
        });

        // Back to login button action
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
    }
}
