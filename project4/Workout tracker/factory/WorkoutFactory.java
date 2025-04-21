package factory;

import model.Workout;
import java.time.LocalDate;

public class WorkoutFactory {

    // Factory method to create a new workout
    public static Workout createWorkout(LocalDate date, String type, int duration, int calories) {
        return new Workout(date, type, duration, calories);
    }
}
