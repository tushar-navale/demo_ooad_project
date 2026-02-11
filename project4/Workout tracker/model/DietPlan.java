package model;

public class DietPlan {
    private String mealType;
    private String foodItems;
    private int calories;

    public DietPlan(String mealType, String foodItems, int calories) {
        this.mealType = mealType;
        this.foodItems = foodItems;
        this.calories = calories;
    }

    public String getMealType() {
        return mealType;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return mealType + ": " + foodItems + " (" + calories + " cal)";
    }
}
