package com.getstrongtoolbox.getstrong.services;

import com.getstrongtoolbox.getstrong.domain.StartingStrong;

import java.util.List;

public interface StartingStrongService {

    List<StartingStrong> getWorkouts();

    StartingStrong getWorkoutById(Long id);

    StartingStrong createWorkout(StartingStrong workout);

    void deleteWorkout(Long id);

}
