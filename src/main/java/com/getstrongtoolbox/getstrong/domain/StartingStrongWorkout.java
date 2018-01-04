package com.getstrongtoolbox.getstrong.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class StartingStrongWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer squat;
    private Integer press;
    private Integer benchPress;
    private Integer deadLift;
    private Integer powerClean;
    private Integer pullUp;

    @NotNull
    private LocalDate date;
}
