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

        setTitle("FitLife");
        // Set to full screen
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

        // Create login panel with white background and shadow effect
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setPreferredSize(new Dimension(400, 450));
        loginPanel.setOpaque(false);

        // Add components with GridBagConstraints for better positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Title
        JLabel titleLabel = new JLabel("Welcome to FitLife");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(titleLabel, gbc);

        // Email field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 35));
        loginPanel.add(emailLabel, gbc);
        loginPanel.add(emailField, gbc);

        // Password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 35));
        loginPanel.add(passwordLabel, gbc);
        loginPanel.add(passwordField, gbc);

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // Style buttons
        loginButton.setPreferredSize(new Dimension(300, 40));
        registerButton.setPreferredSize(new Dimension(300, 40));
        
        loginButton.setBackground(new Color(45, 45, 45));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        
        registerButton.setBackground(new Color(100, 100, 100));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);

        gbc.insets = new Insets(20, 30, 10, 30);
        loginPanel.add(loginButton, gbc);
        gbc.insets = new Insets(10, 30, 20, 30);
        loginPanel.add(registerButton, gbc);

        mainPanel.add(loginPanel);
        add(mainPanel);

        // Add login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = userController.loginUser(email, password);
                if (user != null) {
                    new DashboardView(user).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginView.this, "Invalid credentials, please try again.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterView().setVisible(true);
                dispose();
            }
        });
    }
}
