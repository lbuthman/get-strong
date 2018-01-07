package com.getstrongtoolbox.getstrong.services;

import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;
import com.getstrongtoolbox.getstrong.repositories.StartingStrongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartingStrongServiceImpl implements StartingStrongService {

    private final Logger logger = LoggerFactory.getLogger(StartingStrongServiceImpl.class);
    private final StartingStrongRepository repository;

    public StartingStrongServiceImpl(StartingStrongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StartingStrongWorkout> getWorkouts() {
        logger.debug("Starting Strong Service to get workouts from repository.");
        return repository.findAllByOrderByIdDesc();
    }

    @Override
    public StartingStrongWorkout getWorkoutById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public StartingStrongWorkout createWorkout(StartingStrongWorkout workout) {
        logger.debug("Starting Strong Service to save workout {} to repository.", workout);
        return repository.save(workout);
    }

    @Override
    public void deleteWorkout(Long id) {
        logger.debug("Starting Strong Service to delete workout id = {} from repository.", id);
        repository.delete(id);

    }
}
