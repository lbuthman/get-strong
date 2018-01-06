import { Component, OnInit, Input } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase-list',
  templateUrl: './phase-list.component.html',
  styleUrls: ['./phase-list.component.css']
})
export class PhaseListComponent implements OnInit {

  @Input() workout: StartingStrengthWorkout = {
    id: 1,
    squat: 135,
    press: 135,
    benchPress: 135,
    deadLift: 135,
    powerClean: 135,
    pullUp: 135,
    date: "01-01-18",
  };

  @Input() phase: string = "phase1";

  constructor() { }

  ngOnInit() {
  }

}
