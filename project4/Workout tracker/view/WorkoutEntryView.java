package view;

import controller.WorkoutController;
import model.Workout;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class WorkoutEntryView extends JFrame {
    private WorkoutController controller;
    private DashboardView dashboard;
    private JTextField typeField, durationField, caloriesField;
    private JButton saveButton;

    public WorkoutEntryView(WorkoutController controller, DashboardView dashboard) {
        this.controller = controller;
        this.dashboard = dashboard;

        setTitle("Workout Entry");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Labels & Fields
        JLabel typeLabel = new JLabel("Workout Type:");
        typeField = new JTextField();

        JLabel durationLabel = new JLabel("Duration (mins):");
        durationField = new JTextField();

        JLabel caloriesLabel = new JLabel("Calories Burned:");
        caloriesField = new JTextField();

        saveButton = new JButton("Save Workout");

        // Add to layout
        add(typeLabel); add(typeField);
        add(durationLabel); add(durationField);
        add(caloriesLabel); add(caloriesField);
        add(new JLabel()); add(saveButton); // Empty label to align the button

        // Save button action
        saveButton.addActionListener((ActionEvent e) -> saveWorkout());
    }

    private void saveWorkout() {
        try {
            if (typeField.getText().isEmpty() || durationField.getText().isEmpty() || caloriesField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

            String type = typeField.getText();
            int duration = Integer.parseInt(durationField.getText());
            int calories = Integer.parseInt(caloriesField.getText());
            LocalDate date = LocalDate.now();

            Workout workout = new Workout(date, type, duration, calories);
            controller.addWorkout(workout); // Add to user's list

            JOptionPane.showMessageDialog(this, "Workout saved!");
            dashboard.updateWorkoutList(); // Refresh dashboard
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for duration and calories.");
        }
    }
}
