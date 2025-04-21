package controller;

import model.User;
import model.Workout;
import model.ProgressTracker;
import model.DietPlan;
import java.time.LocalDate;

import controller.WorkoutController;


public class DashboardFacade {
    private User user;
    private WorkoutController workoutController;
    private ProgressTracker progressTracker;

    // Constructor that accepts a User object
    public DashboardFacade(User user) {
        this.user = user;
        this.workoutController = new WorkoutController(user);
        this.progressTracker = new ProgressTracker(user);
    }

    // Method to add a workout
    public void addWorkout(LocalDate date, String type, int duration, int calories) {
        workoutController.createAndSaveWorkout(date, type, duration, calories);
    }

    // Method to get the user's progress report
    public String getProgressReport() {
        int totalWorkouts = progressTracker.calculateTotalWorkouts();
int totalCalories = progressTracker.calculateTotalCaloriesBurned();
double avgDuration = progressTracker.calculateAverageWorkoutDuration();

return "Total Workouts: " + totalWorkouts + "\n" +
       "Total Calories Burned: " + totalCalories + "\n" +
       "Average Workout Duration: " + avgDuration + " mins";

    }

    // Method to view the user's diet plan
    public String getDietPlan() {
        return user.getDietPlan();
    }
}
