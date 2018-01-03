package com.getstrongtoolbox.getstrong.services;

import com.getstrongtoolbox.getstrong.domain.Workout;
import com.getstrongtoolbox.getstrong.respositories.Phase1DayARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Phase1DayAService implements WorkoutService {

    private Phase1DayARepository repository;

    public Phase1DayAService(Phase1DayARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Workout> getWorkouts() {
        return repository.findAll();
    }

    @Override
    public Workout createWorkout(Workout workout) {
        return repository.save(workout);
    }

    @Override
    public void deleteWorkout(Long id) {
        repository.delete(id);
    }
}
