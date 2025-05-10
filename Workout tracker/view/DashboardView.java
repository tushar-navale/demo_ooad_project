package view;

import controller.DashboardFacade;
import model.ProgressTracker;
import model.User;
import model.Workout;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private User user;
    private DashboardFacade facade;
    private JTextArea workoutListArea;

    public DashboardView(User user) {
        this.user = user;
        this.facade = new DashboardFacade(user);

        setTitle("FitLife Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create main container
        JPanel mainContainer = new JPanel(new BorderLayout());
        
        // Create and style navbar
        JPanel navbar = createNavbar();
        
        // Create main content panel
        JPanel contentPanel = createContentPanel();

        mainContainer.add(navbar, BorderLayout.WEST);
        mainContainer.add(contentPanel, BorderLayout.CENTER);
        
        add(mainContainer);
    }

    private JPanel createNavbar() {
        JPanel navbar = new JPanel();
        navbar.setPreferredSize(new Dimension(300, 0));
        navbar.setBackground(new Color(33, 33, 33));
        navbar.setLayout(new BoxLayout(navbar, BoxLayout.Y_AXIS));
        
        // Add FitLife title
        JLabel titleLabel = new JLabel("FitLife");
        titleLabel.setForeground(new Color(192, 57, 43));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        navbar.add(titleLabel);
        navbar.add(new JSeparator());
        
        // Enhanced profile panel
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBackground(new Color(33, 33, 33));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 25));
        
        JLabel welcomeLabel = new JLabel("Welcome,");
        welcomeLabel.setForeground(new Color(158, 158, 158));
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        JLabel nameLabel = new JLabel(user.getName());
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 26));
        
        profilePanel.add(welcomeLabel);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        profilePanel.add(nameLabel);
        
        navbar.add(profilePanel);
        navbar.add(new JSeparator());

        // Create and add navigation buttons
        String[] buttonLabels = {
            "Add Workout", "View Progress", "View Diet Plan",
            "Edit Diet Plan", "Build Workout Plan"
        };

        for (String label : buttonLabels) {
            JButton navButton = createNavButton(label);
            navbar.add(Box.createRigidArea(new Dimension(0, 10)));
            navbar.add(navButton);
        }

        // Add spacing before logout button
        navbar.add(Box.createVerticalGlue());
        
        // Add separator before logout
        JSeparator logoutSeparator = new JSeparator();
        logoutSeparator.setMaximumSize(new Dimension(280, 1));
        logoutSeparator.setForeground(new Color(60, 60, 60));
        navbar.add(logoutSeparator);
        
        // Create and add logout button
        JButton logoutButton = createNavButton("Logout");
        logoutButton.setBackground(new Color(192, 57, 43));
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButton.setBackground(new Color(231, 76, 60));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButton.setBackground(new Color(192, 57, 43));
            }
        });
        logoutButton.addActionListener(e -> logout());
        
        navbar.add(Box.createRigidArea(new Dimension(0, 10)));
        navbar.add(logoutButton);
        navbar.add(Box.createRigidArea(new Dimension(0, 20)));

        return navbar;
    }

    // Add logout method
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to logout?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            new LoginView().setVisible(true);
            dispose();
        }
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(280, 50)); // Increased size
        button.setPreferredSize(new Dimension(280, 50));
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Increased font
        button.setBackground(new Color(45, 45, 45));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 60, 60));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(45, 45, 45));
            }
        });

        // Add action listeners
        switch (text) {
            case "Add Workout":
                button.addActionListener(e -> new WorkoutEntryView(facade, this).setVisible(true));
                break;
            case "View Progress":
                button.addActionListener(e -> showProgress());
                break;
            case "View Diet Plan":
                button.addActionListener(e -> showDietPlan());
                break;
            case "Edit Diet Plan":
                button.addActionListener(e -> new DietPlanView(user).setVisible(true));
                break;
            case "Build Workout Plan":
                button.addActionListener(e -> new WorkoutPlanBuilderView(user).setVisible(true));
                break;
        }

        return button;
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout(20, 20)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(245, 245, 245);
                Color color2 = Color.WHITE;
                GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        contentPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Enhanced title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(245, 245, 245));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        JLabel titleLabel = new JLabel("Your Workout History");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(33, 33, 33));
        titlePanel.add(titleLabel, BorderLayout.WEST);

        // Enhanced workout list panel
        JPanel workoutPanel = new JPanel(new BorderLayout());
        workoutPanel.setBackground(Color.WHITE);
        workoutPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));

        workoutListArea = new JTextArea();
        workoutListArea.setFont(new Font("Arial", Font.PLAIN, 16));
        workoutListArea.setBackground(Color.WHITE);
        workoutListArea.setEditable(false);
        workoutListArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        workoutListArea.setLineWrap(true);
        workoutListArea.setWrapStyleWord(true);
        updateWorkoutList();

        JScrollPane scrollPane = new JScrollPane(workoutListArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);
        workoutPanel.add(scrollPane, BorderLayout.CENTER);

        contentPanel.add(titlePanel, BorderLayout.NORTH);
        contentPanel.add(workoutPanel, BorderLayout.CENTER);

        return contentPanel;
    }

    public void updateWorkoutList() {
        StringBuilder sb = new StringBuilder();
        for (Workout w : user.getWorkouts()) {
            sb.append(" ").append(w.getDate()).append("\n")
              .append("   Type: ").append(w.getType()).append("\n")
              .append("   Duration: ").append(w.getDuration()).append(" mins\n")
              .append("   Calories: ").append(w.getCalories()).append(" cal\n")
              .append(w.toString()).append("\n\n");
        }
        workoutListArea.setText(sb.toString());
    }

    private void showProgress() {
        ProgressTracker tracker = new ProgressTracker(user);
        String message = "Total Workouts: " + tracker.calculateTotalWorkouts() + "\n" +
                        "Total Calories Burned: " + tracker.calculateTotalCaloriesBurned() + "\n" +
                        "Average Workout Duration: " + tracker.calculateAverageWorkoutDuration() + " mins";
        JOptionPane.showMessageDialog(this, message, "Progress Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showDietPlan() {
        String message = facade.getDietPlans();
        if (message.isEmpty()) {
            message = "No diet plans found. Please add meals in the Edit Diet Plan section.";
        }
        JOptionPane.showMessageDialog(this, message, "Diet Plan", JOptionPane.INFORMATION_MESSAGE);
    }
}
