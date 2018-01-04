package com.getstrongtoolbox.getstrong.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class StartingStrongWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int squat;
    private int press;
    private int benchPress;
    private int deadLift;
    private int powerClean;
    private int pullUp;
    private String date;
}
