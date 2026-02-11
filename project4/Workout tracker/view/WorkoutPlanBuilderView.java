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
        setSize(700, 400);
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
        JPanel southPanel = new JPanel();
        southPanel.add(saveBtn);
        add(southPanel, BorderLayout.SOUTH);

        // Plan display area
        planDisplayArea = new JTextArea(10, 30);
        planDisplayArea.setEditable(false);
        planDisplayArea.setBorder(BorderFactory.createTitledBorder("Created Workout Plan"));
        add(new JScrollPane(planDisplayArea), BorderLayout.EAST);
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

        // Display plan
        StringBuilder sb = new StringBuilder();
        sb.append("Plan Name: ").append(plan.getName()).append("\n\n");
        for (Workout w : plan.getWorkouts()) {
            sb.append("- ").append(w.getType())
              .append(" | ").append(w.getDuration()).append(" mins")
              .append(" | ").append(w.getCalories()).append(" cal\n");
        }
        planDisplayArea.setText(sb.toString());
    }
}
