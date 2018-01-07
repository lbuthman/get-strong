package com.getstrongtoolbox.getstrong.dev_data;

import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;
import com.getstrongtoolbox.getstrong.repositories.StartingStrongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevData implements ApplicationListener<ContextRefreshedEvent> {

    private final StartingStrongRepository repository;

    public DevData(StartingStrongRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        repository.save(getWorkouts());
    }

    private List<StartingStrongWorkout> getWorkouts() {
        List<StartingStrongWorkout> workouts = new ArrayList<>();

        StartingStrongWorkout workout1 = new StartingStrongWorkout();
        workout1.setSquat(95);
        workout1.setPress(95);
        workout1.setBenchPress(95);
        workout1.setDeadLift(95);
        workout1.setPowerClean(95);
        workout1.setPullUp(1);
        workout1.setDate("01-01-18");
        workouts.add(workout1);

        StartingStrongWorkout workout2 = new StartingStrongWorkout();
        workout2.setSquat(115);
        workout2.setPress(115);
        workout2.setBenchPress(115);
        workout2.setDeadLift(115);
        workout2.setPowerClean(115);
        workout2.setPullUp(2);
        workout2.setDate("01-02-18");
        workouts.add(workout2);

        StartingStrongWorkout workout3 = new StartingStrongWorkout();
        workout3.setSquat(135);
        workout3.setPress(135);
        workout3.setBenchPress(135);
        workout3.setDeadLift(135);
        workout3.setPowerClean(135);
        workout3.setPullUp(3);
        workout3.setDate("01-03-18");
        workouts.add(workout3);

        StartingStrongWorkout workout4 = new StartingStrongWorkout();
        workout4.setSquat(155);
        workout4.setPress(155);
        workout4.setBenchPress(155);
        workout4.setDeadLift(155);
        workout4.setPowerClean(155);
        workout4.setPullUp(4);
        workout4.setDate("01-04-18");
        workouts.add(workout4);

        return workouts;
    }
}
