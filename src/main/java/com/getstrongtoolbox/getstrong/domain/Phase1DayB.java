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
public class Phase1DayB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer squat;

    @NotNull
    private Integer benchPress;

    @NotNull
    private Integer deadlift;

    @NotNull
    private LocalDate date;
}
