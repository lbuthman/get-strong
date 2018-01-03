package com.getstrongtoolbox.getstrong.services;

import com.getstrongtoolbox.getstrong.domain.Workout;

import java.util.List;

public interface WorkoutService {

    List<Workout> getWorkouts();

    Workout createWorkout(Workout workout);

    void deleteWorkout(Long id);

}
