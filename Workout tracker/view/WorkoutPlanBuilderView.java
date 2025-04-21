package view;

import model.User;
import model.Workout;
import model.WorkoutPlan;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutPlanBuilderView extends JFrame {
    private User user;
    private WorkoutPlan.Builder builder;
    private JTextField planNameField;
    private JList<String> workoutList;
    private DefaultListModel<String> listModel;
    private JTextArea planDisplayArea;

    public WorkoutPlanBuilderView(User user) {
        this.user = user;
        this.builder = new WorkoutPlan.Builder();

        setTitle("Build Workout Plan");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main container
        JPanel mainContainer = new JPanel(new BorderLayout(20, 20));
        mainContainer.setBackground(new Color(245, 245, 245));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(245, 245, 245));
        JLabel titleLabel = new JLabel("Create Your Workout Plan");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(33, 33, 33));
        titlePanel.add(titleLabel, BorderLayout.WEST);

        // Plan name panel
        JPanel planNamePanel = new JPanel(new GridBagLayout());
        planNamePanel.setBackground(Color.WHITE);
        planNamePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel planNameLabel = new JLabel("Plan Name");
        planNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        planNameField = new JTextField();
        planNameField.setPreferredSize(new Dimension(300, 35));
        planNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        planNameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 5, 0);
        planNamePanel.add(planNameLabel, gbc);
        gbc.gridy = 1;
        planNamePanel.add(planNameField, gbc);

        // Content Panel (Workout List and Plan Display)
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setBackground(new Color(245, 245, 245));

        // Workout List Panel
        JPanel workoutListPanel = new JPanel(new BorderLayout());
        workoutListPanel.setBackground(Color.WHITE);
        workoutListPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel workoutListLabel = new JLabel("Available Workouts");
        workoutListLabel.setFont(new Font("Arial", Font.BOLD, 18));
        workoutListPanel.add(workoutListLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        for (Workout w : user.getWorkouts()) {
            listModel.addElement("🏋️ " + w.getDate() + " - " + w.getType());
        }
        workoutList = new JList<>(listModel);
        workoutList.setFont(new Font("Arial", Font.PLAIN, 14));
        workoutList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        workoutList.setBackground(Color.WHITE);
        
        JScrollPane workoutScrollPane = new JScrollPane(workoutList);
        workoutScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        workoutListPanel.add(workoutScrollPane, BorderLayout.CENTER);

        // Plan Display Panel
        JPanel planDisplayPanel = new JPanel(new BorderLayout());
        planDisplayPanel.setBackground(Color.WHITE);
        planDisplayPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel planDisplayLabel = new JLabel("Your Plan");
        planDisplayLabel.setFont(new Font("Arial", Font.BOLD, 18));
        planDisplayPanel.add(planDisplayLabel, BorderLayout.NORTH);

        planDisplayArea = new JTextArea();
        planDisplayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        planDisplayArea.setEditable(false);
        planDisplayArea.setBackground(Color.WHITE);
        planDisplayArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane planScrollPane = new JScrollPane(planDisplayArea);
        planScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        planDisplayPanel.add(planScrollPane, BorderLayout.CENTER);

        // Save Button
        JButton saveButton = new JButton("Save Workout Plan");
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.setPreferredSize(new Dimension(200, 45));
        saveButton.setBackground(new Color(41, 128, 185));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorderPainted(false);
        saveButton.addActionListener(e -> saveWorkoutPlan());

        // Add panels to content panel
        contentPanel.add(workoutListPanel);
        contentPanel.add(planDisplayPanel);

        // Layout assembly
        JPanel centerPanel = new JPanel(new BorderLayout(0, 20));
        centerPanel.setBackground(new Color(245, 245, 245));
        centerPanel.add(planNamePanel, BorderLayout.NORTH);
        centerPanel.add(contentPanel, BorderLayout.CENTER);
        centerPanel.add(saveButton, BorderLayout.SOUTH);

        mainContainer.add(titlePanel, BorderLayout.NORTH);
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        
        add(mainContainer);
    }

    private void saveWorkoutPlan() {
        String planName = planNameField.getText();
        if (planName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter a plan name.",
                "Missing Information",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        builder.setName(planName);
        List<String> selectedValues = workoutList.getSelectedValuesList();

        if (selectedValues.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please select at least one workout.",
                "Missing Selection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String selected : selectedValues) {
            String cleanedSelection = selected.replace("🏋️ ", "");
            for (Workout w : user.getWorkouts()) {
                if ((w.getDate() + " - " + w.getType()).equals(cleanedSelection)) {
                    builder.addWorkout(w);
                }
            }
        }

        WorkoutPlan plan = builder.build();
        user.addWorkoutPlan(plan);

        // Display plan with improved formatting
        StringBuilder sb = new StringBuilder();
        sb.append("📋 Plan Name: ").append(plan.getName()).append("\n\n");
        for (Workout w : plan.getWorkouts()) {
            sb.append("🏋️ ").append(w.getType()).append("\n")
              .append("   Duration: ").append(w.getDuration()).append(" mins\n")
              .append("   Calories: ").append(w.getCalories()).append(" cal\n\n");
        }
        planDisplayArea.setText(sb.toString());

        JOptionPane.showMessageDialog(this,
            "Workout plan created successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
