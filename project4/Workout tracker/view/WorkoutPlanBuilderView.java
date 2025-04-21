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

    public WorkoutPlanBuilderView(User user) {
        this.user = user;
        this.builder = new WorkoutPlan.Builder();

        setTitle("Build Workout Plan");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Plan name input
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Plan Name:"));
        planNameField = new JTextField(20);
        topPanel.add(planNameField);
        add(topPanel, BorderLayout.NORTH);

        // Workout list (selectable)
        listModel = new DefaultListModel<>();
        for (Workout w : user.getWorkouts()) {
            listModel.addElement(w.getDate() + " - " + w.getType());
        }
        workoutList = new JList<>(listModel);
        workoutList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(workoutList), BorderLayout.CENTER);

        // Save button
        JButton saveBtn = new JButton("Save Workout Plan");
        saveBtn.addActionListener(e -> saveWorkoutPlan());
        add(saveBtn, BorderLayout.SOUTH);
    }

    private void saveWorkoutPlan() {
        String planName = planNameField.getText();
        if (planName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a plan name.");
            return;
        }

        builder.setName(planName);
        List<String> selectedValues = workoutList.getSelectedValuesList();

        for (String selected : selectedValues) {
            for (Workout w : user.getWorkouts()) {
                if ((w.getDate() + " - " + w.getType()).equals(selected)) {
                    builder.addWorkout(w);
                }
            }
        }
        WorkoutPlan plan = builder.build();
        user.addWorkoutPlan(plan); // Save the plan to user
        JOptionPane.showMessageDialog(this, "Workout Plan '" + plan.getName() + "' created with " +
                plan.getWorkouts().size() + " workouts.");
        dispose();
        
    }
}
