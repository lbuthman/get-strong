package com.getstrongtoolbox.getstrong.web.rest;

import com.getstrongtoolbox.getstrong.domain.StartingStrong;
import com.getstrongtoolbox.getstrong.services.StartingStrongService;
import com.getstrongtoolbox.getstrong.web.rest.errors.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/starting-strong")
public class StartingStrongController {

    private final static String ENTITY = "StartingStrong";

    private final Logger logger = LoggerFactory.getLogger(StartingStrongController.class);
    private final StartingStrongService service;

    public StartingStrongController(StartingStrongService service) {
        this.service = service;
    }

    /**
     * GET /api/v1/starting-strong
     *
     * @return a status of 200 (OK) and a list of Starting Strong workouts
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StartingStrong> getWorkouts() {
        logger.debug("REST request to get workouts from repository.");
        return service.getWorkouts();
    }

    /**
     * POST /api/v1/starting-strong
     *
     * @param workout : the Starting Strong workout to save
     * @return a status of 201 (CREATED) and the new workout
     * or a status of 400 (BAD REQUEST) if workout id already exists
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StartingStrong createWorkout(StartingStrong workout) {
        logger.debug("REST request to save workout {} to repository.", workout);
        if (workout.getId() != null) {
            throw new BadRequestException("A workout cannot already have an id.", ENTITY);
        }
        return service.createWorkout(workout);
    }

    /**
     * DELETE /api/v1/starting-strong
     *
     * @param id : the Starting Strong workout id to delete
     * return a status of 200 (OK)
     * or a status of 400 (BAD REQUEST) if workout cannot be found
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        logger.debug("REST request to delete workout id = {} from repository.", id);
        StartingStrong workoutToDelete = service.getWorkoutById(id);
        if (workoutToDelete == null) {
            throw new BadRequestException("Workout with id = " + id + " does not exist", ENTITY);
        }
        service.deleteWorkout(id);
    }
}