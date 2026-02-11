package model;

import model.Workout; // Ensure the Workout class is imported
import model.User; // Import the User class

public class ProgressTracker {
    private User user;

    public ProgressTracker(User user) {
        this.user = user;
    }

    // Calculate total workouts performed by the user
    public int calculateTotalWorkouts() {
        return user.getWorkouts().size();
    }

    // Calculate total calories burned by the user
    public int calculateTotalCaloriesBurned() {
        int totalCalories = 0;
        for (Workout workout : user.getWorkouts()) {
            totalCalories += workout.getCalories();
        }
        return totalCalories;
    }

    // Calculate the average workout duration
    public double calculateAverageWorkoutDuration() {
        if (user.getWorkouts().size() == 0) {
            return 0;
        }
        int totalDuration = 0;
        for (Workout workout : user.getWorkouts()) {
            totalDuration += workout.getDuration();
        }
        return (double) totalDuration / user.getWorkouts().size();
    }

    // Method to display progress (or any other business logic you want)
    public void displayProgress() {
        System.out.println("Displaying progress for user: " + user.getName());
        System.out.println("Total Workouts: " + calculateTotalWorkouts());
        System.out.println("Total Calories Burned: " + calculateTotalCaloriesBurned());
        System.out.println("Average Workout Duration: " + calculateAverageWorkoutDuration() + " minutes");
    }
}
