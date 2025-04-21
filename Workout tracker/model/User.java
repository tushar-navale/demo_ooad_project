package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Workout> workouts;
    private List<DietPlan> dietPlans; // List to store multiple diet plans

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.workouts = new ArrayList<>();
        this.dietPlans = new ArrayList<>(); // Initialize the dietPlans list
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<DietPlan> getDietPlans() {
        return dietPlans; // Return the list of diet plans
    }

    public void addDietPlan(DietPlan plan) {
        dietPlans.add(plan); // Add a new diet plan to the list
    }

    private List<WorkoutPlan> workoutPlans = new ArrayList<>();

public void addWorkoutPlan(WorkoutPlan plan) {
    workoutPlans.add(plan);
}

public List<WorkoutPlan> getWorkoutPlans() {
    return workoutPlans;
}

}

