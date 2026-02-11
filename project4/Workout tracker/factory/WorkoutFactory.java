package factory;

import model.Workout;

import java.time.LocalDate;

public class WorkoutFactory {
    public static Workout createWorkout(String type, int durationInMinutes) {
        int calories = calculateCalories(type, durationInMinutes);
        return new Workout(LocalDate.now(), type, durationInMinutes, calories);
    }

    private static int calculateCalories(String type, int duration) {
        switch (type.toLowerCase()) {
            case "cardio":
                return duration * 10;
            case "strength":
                return duration * 8;
            case "yoga":
                return duration * 5;
            case "hiit":
                return duration * 12;
            default:
                return duration * 6; // default average
        }
    }
}
