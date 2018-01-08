package com.getstrongtoolbox.getstrong.web.rest;

import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;
import com.getstrongtoolbox.getstrong.services.StartingStrongService;
import com.getstrongtoolbox.getstrong.web.rest.errors.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/starting-strong")
public class StartingStrongController {

    private final static String ENTITY = "StartingStrong";

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
    public List<StartingStrongWorkout> getWorkouts() {
        log.info("REST request to get workouts from repository.");
        return service.getWorkouts();
    }

    /**
     * GET /api/v1/starting-strong/most-recent
     *
     * @return a status of 200 (OK) and the most recent workout added to database
     */
    @GetMapping("/most-recent")
    @ResponseStatus(HttpStatus.OK)
    public StartingStrongWorkout getMostRecentWorkout() {
        log.info("REST request to get most recent workout from repository.");
        return service.getMostRecentWorkout();
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
    public StartingStrongWorkout createWorkout(@RequestBody StartingStrongWorkout workout) {
        log.info("REST request to save workout {} to repository.", workout);
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
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorkout(@PathVariable Long id) {
        log.info("REST request to delete workout id = {} from repository.", id);
        StartingStrongWorkout workoutToDelete = service.getWorkoutById(id);
        if (workoutToDelete == null) {
            throw new BadRequestException("Workout with id = " + id + " does not exist", ENTITY);
        }
        service.deleteWorkout(id);
    }
}
