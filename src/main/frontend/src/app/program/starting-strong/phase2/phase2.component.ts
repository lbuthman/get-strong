import { Component, OnInit } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase2',
  templateUrl: './phase2.component.html',
  styleUrls: ['./phase2.component.css']
})
export class Phase2Component implements OnInit {

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

  phase: String = "phase2";

  constructor() { }

  ngOnInit() {
  }

}
