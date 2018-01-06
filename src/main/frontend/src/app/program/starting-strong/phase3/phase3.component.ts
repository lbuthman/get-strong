import { Component, OnInit } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase3',
  templateUrl: './phase3.component.html',
  styleUrls: ['./phase3.component.css']
})
export class Phase3Component implements OnInit {

  currentWorkout: StartingStrengthWorkout = {
    id: 1,
    squat: 135,
    press: 135,
    benchPress: 135,
    deadLift: 135,
    powerClean: 135,
    pullUp: 135,
    date: "01-01-18",
  };

  workouts: StartingStrengthWorkout[] = [
    {
      id: 1,
      squat: 135,
      press: 135,
      benchPress: 135,
      deadLift: 135,
      powerClean: 135,
      pullUp: 135,
      date: "01-01-18",
    },
    {
      id: 1,
      squat: 135,
      press: 135,
      benchPress: 135,
      deadLift: 135,
      powerClean: 135,
      pullUp: 135,
      date: "01-01-18",
    },
  ];

  phase: String = "phase3";

  constructor() { }

  ngOnInit() {
  }

}
