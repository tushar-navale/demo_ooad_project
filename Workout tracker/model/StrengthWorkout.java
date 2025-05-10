package model;

import java.time.LocalDate;

public class StrengthWorkout extends Workout {
    public StrengthWorkout(LocalDate date, int duration, int calories) {
        super(date, "Strength", duration, calories);
    }
//     @Override
// public String toString() {
//     return super.toString() + "\n   Note: Strength training 💪";
// }

}
