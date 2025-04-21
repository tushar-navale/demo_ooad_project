package factory;
  
import model.DietPlan;

public class DietPlanFactory {
    public static DietPlan createDietPlan(String mealType, String foodItems, int calories) {
        return new DietPlan(mealType, foodItems, calories);
    }
}