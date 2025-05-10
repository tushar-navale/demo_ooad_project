package model;

import java.time.LocalDate;

public class Workout {
    private LocalDate date;
    private String type;
    private int duration; // in minutes
    private int calories; // calories burned

    public Workout(LocalDate date, String type, int duration, int calories) {
        this.date = date;
        this.type = type;
        this.duration = duration;
        this.calories = calories;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getCalories() {
        return calories;
    }

    @Override
public String toString() {
   return " "; 
//            "   Type: " + type + "\n" +
//            "   Duration: " + duration + " mins\n" +
//            "   Calories: " + calories + " cal";
}

}
