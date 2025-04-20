package view;

import controller.WorkoutController;
import model.User;
import model.Workout;
import model.ProgressTracker;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private User user;
    private WorkoutController controller;
    private JTextArea workoutListArea;

    public DashboardView(User user) {
        this.user = user;
        this.controller = new WorkoutController(user);

        setTitle("Dashboard - " + user.getName());
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        workoutListArea = new JTextArea();
        updateWorkoutList();

        JButton addBtn = new JButton("Add Workout");
        addBtn.addActionListener(e -> new WorkoutEntryView(controller, this).setVisible(true));

        JButton progressBtn = new JButton("View Progress");
        progressBtn.addActionListener(e -> {
            ProgressTracker tracker = new ProgressTracker(user);
            String message = "Total Workouts: " + tracker.calculateTotalWorkouts() + "\n" +
                             "Total Calories Burned: " + tracker.calculateTotalCaloriesBurned() + "\n" +
                             "Average Workout Duration: " + tracker.calculateAverageWorkoutDuration() + " mins";
            JOptionPane.showMessageDialog(this, message, "Progress Report", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton dietBtn = new JButton("View Diet Plan");
        dietBtn.addActionListener(e -> new DietPlanView(user).setVisible(true));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addBtn);
        buttonPanel.add(progressBtn);
        buttonPanel.add(dietBtn);

        add(new JScrollPane(workoutListArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateWorkoutList() {
        StringBuilder sb = new StringBuilder("Your Workouts:\n");
        for (Workout w : user.getWorkouts()) {
            sb.append(w.getDate()).append(" - ")
              .append(w.getType()).append(", ")
              .append(w.getDuration()).append(" mins, ")
              .append(w.getCalories()).append(" cal\n");
        }
        workoutListArea.setText(sb.toString());
    }

    public JTextArea getWorkoutListArea() {
        return workoutListArea;
    }
}
