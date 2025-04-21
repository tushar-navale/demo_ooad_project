package view;

import model.DietPlan;
import model.User;

import javax.swing.*;
import java.awt.*;

public class DietPlanView extends JFrame {
    private User user;
    private JComboBox<String> mealTypeCombo;
    private JTextField foodItemsField;
    private JTextField caloriesField;
    private JTextArea dietListArea;

    public DietPlanView(User user) {
        this.user = user;

        setTitle("Diet Plan");
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top Panel for inputs
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        mealTypeCombo = new JComboBox<>(new String[]{"Breakfast", "Lunch", "Dinner", "Snack"});
        foodItemsField = new JTextField();
        caloriesField = new JTextField();

        inputPanel.add(new JLabel("Meal Type:"));
        inputPanel.add(mealTypeCombo);
        inputPanel.add(new JLabel("Food Items:"));
        inputPanel.add(foodItemsField);
        inputPanel.add(new JLabel("Calories:"));
        inputPanel.add(caloriesField);

        JButton addButton = new JButton("Add Meal");
        inputPanel.add(new JLabel()); // empty cell
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Center Panel to display added meals
        dietListArea = new JTextArea();
        dietListArea.setEditable(false);
        add(new JScrollPane(dietListArea), BorderLayout.CENTER);

        // Add meal button logic
        addButton.addActionListener(e -> {
            String mealType = (String) mealTypeCombo.getSelectedItem();
            String foodItems = foodItemsField.getText();
            int calories;

            if (foodItems.isEmpty() || caloriesField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            try {
                calories = Integer.parseInt(caloriesField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Calories must be a number.");
                return;
            }

            // Create a DietPlan object and add it to the User's diet plans
            DietPlan dietPlan = new DietPlan(mealType, foodItems, calories);
            user.addDietPlan(dietPlan); // Save diet plan to the User

            updateDietList(); // Refresh the displayed diet plans

            // Clear input fields after adding the meal
            foodItemsField.setText("");
            caloriesField.setText("");
        });

        // Display existing diet plans when the view is initialized
        updateDietList();
    }

    private void updateDietList() {
        StringBuilder sb = new StringBuilder("Your Diet Plan:\n\n");
        for (DietPlan plan : user.getDietPlans()) {
            sb.append(plan.toString()).append("\n");
        }
        dietListArea.setText(sb.toString()); // Update the JTextArea with the list of diet plans
    }
}
