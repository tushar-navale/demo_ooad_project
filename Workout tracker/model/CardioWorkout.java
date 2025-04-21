package model;

import java.time.LocalDate;

public class CardioWorkout extends Workout {
    public CardioWorkout(LocalDate date, int duration, int calories) {
        super(date, "Cardio", duration, calories);
    }
    @Override
public String toString() { 
    return super.toString() + "\n   Note: This was a cardio session ";
}

}
