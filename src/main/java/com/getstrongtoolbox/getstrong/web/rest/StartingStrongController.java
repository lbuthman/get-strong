package com.getstrongtoolbox.getstrong.controllers;

import com.getstrongtoolbox.getstrong.domain.StartingStrong;
import com.getstrongtoolbox.getstrong.services.StartingStrongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/starting-strong")
public class StartingStrongController {

    private final static String ENTITY = "StartingStrong";

    private final Logger log = LoggerFactory.getLogger(StartingStrongController.class);
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
    public List<StartingStrong> getWorkouts() {
        return service.getWorkouts();
    }

    /**
     * POST /api/v1/starting-strong
     *
     * @param workout : the Starting Strong workout to save
     * @return a status of 201 (CREATED) and the new workout
     */
    @PostMapping
    public StartingStrong createWorkout(StartingStrong workout) {
        return service.createWorkout(workout);
    }

    /**
     * DELETE /api/v1/starting-strong
     *
     * @param id : the Starting Strong workout id to delete
     */
    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        service.deleteWorkout(id);
    }
}
