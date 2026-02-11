package view;

import controller.DashboardFacade;
import model.Workout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class WorkoutEntryView extends JFrame {
    private DashboardFacade facade;
    private DashboardView dashboard;
    private JTextField typeField, durationField, caloriesField;
    private JButton saveButton;

    public WorkoutEntryView(DashboardFacade facade, DashboardView dashboard) {
        this.facade = facade;
        this.dashboard = dashboard;

        setTitle("Add New Workout");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Main container with padding
        JPanel mainContainer = new JPanel(new BorderLayout(20, 20));
        mainContainer.setBackground(new Color(245, 245, 245));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(245, 245, 245));
        JLabel titleLabel = new JLabel("Add New Workout");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(33, 33, 33));
        titlePanel.add(titleLabel, BorderLayout.WEST);
        
        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 1;
        
        // Workout Type
        JLabel typeLabel = new JLabel("Workout Type");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        typeField = createStyledTextField();
        
        // Duration
        JLabel durationLabel = new JLabel("Duration (mins)");
        durationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        durationField = createStyledTextField();
        
        // Calories
        JLabel caloriesLabel = new JLabel("Calories Burned");
        caloriesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        caloriesField = createStyledTextField();
        
        // Save Button
        saveButton = new JButton("Save Workout");
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.setPreferredSize(new Dimension(200, 45));
        saveButton.setBackground(new Color(41, 128, 185));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorderPainted(false);
        
        // Add components to form
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(typeLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(typeField, gbc);
        
        gbc.gridy = 2;
        formPanel.add(durationLabel, gbc);
        gbc.gridy = 3;
        formPanel.add(durationField, gbc);
        
        gbc.gridy = 4;
        formPanel.add(caloriesLabel, gbc);
        gbc.gridy = 5;
        formPanel.add(caloriesField, gbc);
        
        gbc.gridy = 7;
        gbc.insets = new Insets(30, 10, 10, 10);
        formPanel.add(saveButton, gbc);

        // Add panels to main container
        mainContainer.add(titlePanel, BorderLayout.NORTH);
        mainContainer.add(formPanel, BorderLayout.CENTER);
        
        add(mainContainer);

        // Save button action
        saveButton.addActionListener((ActionEvent e) -> saveWorkout());
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(300, 35));
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }

    private void saveWorkout() {
        try {
            if (typeField.getText().isEmpty() || durationField.getText().isEmpty() || caloriesField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please fill in all fields.", 
                    "Missing Information", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            String type = typeField.getText();
            int duration = Integer.parseInt(durationField.getText());
            int calories = Integer.parseInt(caloriesField.getText());
            LocalDate date = LocalDate.now();

            facade.addWorkout(date, type, duration, calories);

            JOptionPane.showMessageDialog(this, 
                "Workout saved successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            dashboard.updateWorkoutList();
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers for duration and calories.", 
                "Invalid Input", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
