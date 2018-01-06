import { Component, OnInit, Input } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase-list',
  templateUrl: './phase-list.component.html',
  styleUrls: ['./phase-list.component.css']
})
export class PhaseListComponent implements OnInit {

  @Input() workouts: StartingStrengthWorkout[];

  @Input() phase: string = "phase1";

  constructor() { }

  ngOnInit() {
  }

}
