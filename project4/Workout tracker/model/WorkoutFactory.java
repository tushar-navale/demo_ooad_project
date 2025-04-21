package model;

import java.time.LocalDate;

public class WorkoutFactory {

    // Factory method to create a new Workout object with LocalDate as part of the constructor
    public Workout createWorkout(LocalDate date, String type, int duration, int calories) {
        // Create and return a new Workout object
        return new Workout(date, type, duration, calories);
    }
}
