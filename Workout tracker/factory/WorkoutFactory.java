package factory;

import model.Workout;
import java.time.LocalDate;

import model.CardioWorkout;
import model.StrengthWorkout;

public class WorkoutFactory {

    // Factory method to create a new workout
    public Workout createWorkout(LocalDate date, String type, int duration, int calories) {
        if (type.equalsIgnoreCase("cardio")) {
            return new CardioWorkout(date, duration, calories);
        } else if (type.equalsIgnoreCase("strength")) {
            return new StrengthWorkout(date, duration, calories);
        } else {
            return new Workout(date, type, duration, calories);
        }
    }
}
