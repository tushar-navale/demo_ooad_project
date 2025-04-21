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

        setTitle("Dashboard - " + user.getName());
        setSize(500, 450); // Increased size for better layout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        workoutListArea = new JTextArea();
        updateWorkoutList();

        JButton addBtn = new JButton("Add Workout");
        addBtn.addActionListener(e -> new WorkoutEntryView(facade, this).setVisible(true));

        JButton progressBtn = new JButton("View Progress");
        progressBtn.addActionListener(e -> {
            ProgressTracker tracker = new ProgressTracker(user);
            String message = "Total Workouts: " + tracker.calculateTotalWorkouts() + "\n" +
                             "Total Calories Burned: " + tracker.calculateTotalCaloriesBurned() + "\n" +
                             "Average Workout Duration: " + tracker.calculateAverageWorkoutDuration() + " mins";
            JOptionPane.showMessageDialog(this, message, "Progress Report", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton dietBtn = new JButton("View Diet Plan");
        dietBtn.addActionListener(e -> {
            String message = facade.getDietPlans();
            if (message.isEmpty()) {
                message = "No diet plans found. Please add meals in the Edit Diet Plan section.";
            }
            JOptionPane.showMessageDialog(this, message, "Diet Plan", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton editDietBtn = new JButton("Edit Diet Plan");
        editDietBtn.addActionListener(e -> new DietPlanView(user).setVisible(true)); // ✅ Add back the missing button

        JButton planBtn = new JButton("Build Workout Plan");
        planBtn.addActionListener(e -> new WorkoutPlanBuilderView(user).setVisible(true));

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // Better layout
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(addBtn);
        buttonPanel.add(progressBtn);
        buttonPanel.add(dietBtn);
        buttonPanel.add(editDietBtn); // ✅ Add here
        buttonPanel.add(planBtn);

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
}
