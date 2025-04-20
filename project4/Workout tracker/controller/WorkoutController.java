package controller;

import model.User;
import model.Workout;

public class WorkoutController {
    private User user;

    public WorkoutController(User user) {
        this.user = user;
    }

    // Add this method to return the User object
    public User getUser() {
        return user;
    }

    // Method to add a workout (for example)
    public void addWorkout(Workout workout) {
        user.addWorkout(workout);
    }
}

