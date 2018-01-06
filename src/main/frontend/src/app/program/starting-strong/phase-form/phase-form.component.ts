import { Component, OnInit, Input } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase-form',
  templateUrl: './phase-form.component.html',
  styleUrls: ['./phase-form.component.css']
})
export class PhaseFormComponent implements OnInit {

  @Input() workout: StartingStrengthWorkout;

  @Input() phase: string = "phase3";

  constructor() { }

  ngOnInit() {
  }

}
