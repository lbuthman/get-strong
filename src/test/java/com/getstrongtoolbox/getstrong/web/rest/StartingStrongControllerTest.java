package com.getstrongtoolbox.getstrong.web.rest;

import com.getstrongtoolbox.getstrong.GetStrongApplication;
import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;
import com.getstrongtoolbox.getstrong.repositories.StartingStrongRepository;
import com.getstrongtoolbox.getstrong.services.StartingStrongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GetStrongApplication.class)
public class StartingStrongControllerTest extends AbstractRestControllerTest {

    private final static Integer SQUAT = 185;
    private final static Integer PRESS = 95;
    private final static Integer BENCH_PRESS = 165;
    private final static Integer DEAD_LIFT = 225;
    private final static Integer POWER_CLEAN = 135;
    private final static Integer PULL_UP = 10;
    private final static String DATE = "01-03-18";

    @MockBean
    private StartingStrongService service;

    @Autowired
    private StartingStrongRepository repository;

    private MockMvc mockMvc;

    private StartingStrongWorkout workout;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        final StartingStrongController controller = new StartingStrongController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // Method to easily create workout object for tests
    public static StartingStrongWorkout createTestWorkout() {
        StartingStrongWorkout workout = new StartingStrongWorkout();
        workout.setSquat(SQUAT);
        workout.setPress(PRESS);
        workout.setBenchPress(BENCH_PRESS);
        workout.setDeadLift(DEAD_LIFT);
        workout.setPowerClean(POWER_CLEAN);
        workout.setPullUp(PULL_UP);
        workout.setDate(DATE);
        return workout;
    }

    @Before
    public void initializeTest() {
        repository.deleteAll();
        workout = createTestWorkout();
    }

    @Test
    public void getWorkouts() throws Exception {
        //initialize repository
        repository.saveAndFlush(workout);

        when(service.getWorkouts()).thenReturn(repository.findAll());

        mockMvc.perform(get("/api/v1/starting-strong"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.[*].id").value(hasItems(workout.getId().intValue())))
                .andExpect(jsonPath("$.[*].squat").value(hasItems(workout.getSquat())))
                .andExpect(jsonPath("$.[*].press").value(hasItems(workout.getPress())))
                .andExpect(jsonPath("$.[*].benchPress").value(hasItems(workout.getBenchPress())))
                .andExpect(jsonPath("$.[*].deadLift").value(hasItems(workout.getDeadLift())))
                .andExpect(jsonPath("$.[*].powerClean").value(hasItems(workout.getPowerClean())))
                .andExpect(jsonPath("$.[*].pullUp").value(hasItems(workout.getPullUp())))
                .andExpect(jsonPath("$.[*].date").value(hasItems(workout.getDate())));
    }

    @Test
    public void createWorkout() throws Exception {
        int repoInitSize = repository.findAll().size();

        mockMvc.perform(post("/api/v1/starting-strong")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(workout)))
                .andExpect(status().isCreated());

        List<StartingStrongWorkout> workouts = repository.findAll();
        assertThat(workouts.size() == repoInitSize + 1);
        assertThat(workouts.contains(SQUAT));
        assertThat(workouts.contains(PRESS));
        assertThat(workouts.contains(BENCH_PRESS));
        assertThat(workouts.contains(DEAD_LIFT));
        assertThat(workouts.contains(POWER_CLEAN));
        assertThat(workouts.contains(PULL_UP));
        assertThat(workouts.contains(DATE));
    }

    @Test
    public void createExistingWorkout() throws Exception {
        //initialize repository
        repository.saveAndFlush(workout);

        int repoInitSize = repository.findAll().size();

        mockMvc.perform(post("/api/v1/starting-strong")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(workout)))
                .andExpect(status().isBadRequest());

        assertThat(repository.findAll().size() == repoInitSize);
    }

    @Test
    public void deleteWorkout() throws Exception {
        //initialize repo
        repository.saveAndFlush(workout);

        int repoBeforeDeleteSize = repository.findAll().size();

        when(service.getWorkoutById(workout.getId())).thenReturn(workout);

        mockMvc.perform(delete("/api/v1/starting-strong/" + workout.getId()))
                .andExpect(status().isOk());

        assertThat(repository.findAll().size() < repoBeforeDeleteSize);
    }
}