package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Workout> workouts;
    private List<DietPlan> dietPlans;
    private List<WorkoutPlan> workoutPlans; // List to store workout plans

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.workouts = new ArrayList<>();
        this.dietPlans = new ArrayList<>();
        this.workoutPlans = new ArrayList<>();
    }

    public String setPassword() {
        return password;
    }
    
    public String getPassword() {
        return password;
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<DietPlan> getDietPlans() {
        return dietPlans;
    }

    public void addDietPlan(DietPlan dietPlan) {
        dietPlans.add(dietPlan);
    }

    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void addWorkoutPlan(WorkoutPlan workoutPlan) {
        workoutPlans.add(workoutPlan);
    }
}
