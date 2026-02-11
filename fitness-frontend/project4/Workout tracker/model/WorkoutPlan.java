package model;

import java.util.List;
import java.util.ArrayList;

public class WorkoutPlan {
    private String name;
    private List<Workout> workouts;

    // Private constructor to ensure only the builder can create an instance
    private WorkoutPlan(String name, List<Workout> workouts) {
        this.name = name;
        this.workouts = workouts;
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    // Builder pattern to create WorkoutPlan
    public static class Builder {
        private String name;
        private List<Workout> workouts;

        public Builder() {
            this.workouts = new ArrayList<>();
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder addWorkout(Workout workout) {
            workouts.add(workout);
            return this;
        }

        public WorkoutPlan build() {
            return new WorkoutPlan(name, workouts);
        }
    }
}
