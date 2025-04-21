//User.java
package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Workout> workouts;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.workouts = new ArrayList<>();
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
    private List<DietPlan> dietPlans = new ArrayList<>();

public void addDietPlan(DietPlan plan) {
    dietPlans.add(plan);
}

public List<DietPlan> getDietPlans() {
    return dietPlans;
}

private String dietPlan;

public String getDietPlan() {
    return dietPlan;
}

public void setDietPlan(String dietPlan) {
    this.dietPlan = dietPlan;
}


}
