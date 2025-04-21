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

        setTitle("Diet Plan Management");
        setSize(800, 600);
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
        JLabel titleLabel = new JLabel("Manage Your Diet Plan");
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

        // Meal Type Combo
        JLabel mealTypeLabel = new JLabel("Meal Type");
        mealTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mealTypeCombo = createStyledComboBox();

        // Food Items
        JLabel foodItemsLabel = new JLabel("Food Items");
        foodItemsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        foodItemsField = createStyledTextField();

        // Calories
        JLabel caloriesLabel = new JLabel("Calories");
        caloriesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        caloriesField = createStyledTextField();

        // Add Button
        JButton addButton = new JButton("Add Meal");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setPreferredSize(new Dimension(200, 45));
        addButton.setBackground(new Color(41, 128, 185));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);

        // Add components to form
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(mealTypeLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(mealTypeCombo, gbc);

        gbc.gridy = 2;
        formPanel.add(foodItemsLabel, gbc);
        gbc.gridy = 3;
        formPanel.add(foodItemsField, gbc);

        gbc.gridy = 4;
        formPanel.add(caloriesLabel, gbc);
        gbc.gridy = 5;
        formPanel.add(caloriesField, gbc);

        gbc.gridy = 7;
        gbc.insets = new Insets(30, 10, 10, 10);
        formPanel.add(addButton, gbc);

        // Diet List Panel
        JPanel dietListPanel = new JPanel(new BorderLayout());
        dietListPanel.setBackground(Color.WHITE);
        dietListPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel listTitle = new JLabel("Your Diet Plans");
        listTitle.setFont(new Font("Arial", Font.BOLD, 18));
        dietListPanel.add(listTitle, BorderLayout.NORTH);

        dietListArea = new JTextArea();
        dietListArea.setFont(new Font("Arial", Font.PLAIN, 14));
        dietListArea.setEditable(false);
        dietListArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dietListArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(dietListArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        dietListPanel.add(scrollPane, BorderLayout.CENTER);

        // Layout panels
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(245, 245, 245));
        leftPanel.add(formPanel, BorderLayout.NORTH);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(245, 245, 245));
        rightPanel.add(dietListPanel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setBackground(new Color(245, 245, 245));
        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        mainContainer.add(titlePanel, BorderLayout.NORTH);
        mainContainer.add(contentPanel, BorderLayout.CENTER);
        add(mainContainer);

        // Add meal button logic
        addButton.addActionListener(e -> addMeal());

        updateDietList();
    }

    private JComboBox<String> createStyledComboBox() {
        JComboBox<String> combo = new JComboBox<>(new String[]{"Breakfast", "Lunch", "Dinner", "Snack"});
        combo.setPreferredSize(new Dimension(300, 35));
        combo.setFont(new Font("Arial", Font.PLAIN, 14));
        combo.setBackground(Color.WHITE);
        return combo;
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

    private void addMeal() {
        String mealType = (String) mealTypeCombo.getSelectedItem();
        String foodItems = foodItemsField.getText();

        if (foodItems.isEmpty() || caloriesField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields.", 
                "Missing Information", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int calories = Integer.parseInt(caloriesField.getText());
            DietPlan dietPlan = new DietPlan(mealType, foodItems, calories);
            user.addDietPlan(dietPlan);

            updateDietList();
            foodItemsField.setText("");
            caloriesField.setText("");
            
            JOptionPane.showMessageDialog(this, 
                "Meal added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid number for calories.", 
                "Invalid Input", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDietList() {
        StringBuilder sb = new StringBuilder();
        for (DietPlan plan : user.getDietPlans()) {
            sb.append("🍽️ ").append(plan.getMealType()).append("\n")
              .append("   Foods: ").append(plan.getFoodItems()).append("\n")
              .append("   Calories: ").append(plan.getCalories()).append(" cal\n\n");
        }
        dietListArea.setText(sb.toString());
    }
}
