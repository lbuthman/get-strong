import { Component, OnInit } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase1',
  templateUrl: './phase1.component.html',
  styleUrls: ['./phase1.component.css']
})
export class Phase1Component implements OnInit {

  workout: StartingStrengthWorkout = {
    id: 1,
    squat: 135,
    press: 135,
    benchPress: 135,
    deadLift: 135,
    powerClean: 135,
    pullUp: 135,
    date: "01-01-18",
  };

  phase: String = "phase1";

  constructor() { }

  ngOnInit() {
  }

}
