package model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan {
    private String name;
    private List<Workout> workouts;

    private WorkoutPlan(Builder builder) {
        this.name = builder.name;
        this.workouts = builder.workouts;
    }

    public static class Builder {
        private String name;
        private List<Workout> workouts = new ArrayList<>();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder addWorkout(Workout workout) {
            workouts.add(workout);
            return this;
        }

        public WorkoutPlan build() {
            return new WorkoutPlan(this);
        }
    }

    public String getName() {
        return name;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}
