package controller;

import model.Workout;
import model.WorkoutFactory;
import model.User;
import java.time.LocalDate;

public class WorkoutController {
    private User user;
    private WorkoutFactory workoutFactory;

    // Constructor that accepts a User object
    public WorkoutController(User user) {
        this.user = user;
        this.workoutFactory = new WorkoutFactory(); // Initialize the factory
    }

    // Method to create and save a workout
    public void createAndSaveWorkout(LocalDate date, String type, int duration, int calories) {
        // Use the factory to create the workout object
        Workout workout = workoutFactory.createWorkout(date, type, duration, calories);

        // Save the workout by adding it to the user's workout list
        user.addWorkout(workout);
    }
}
