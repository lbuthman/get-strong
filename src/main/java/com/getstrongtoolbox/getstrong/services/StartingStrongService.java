package com.getstrongtoolbox.getstrong.services;

import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;

import java.util.List;

public interface StartingStrongService {

    List<StartingStrongWorkout> getWorkouts();

    StartingStrongWorkout getWorkoutById(Long id);

    StartingStrongWorkout createWorkout(StartingStrongWorkout workout);

    void deleteWorkout(Long id);

}
