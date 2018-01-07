import { Component, OnInit } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase2',
  templateUrl: './phase2.component.html',
  styleUrls: ['./phase2.component.css']
})
export class Phase2Component implements OnInit {

  phase: String = "phase2";

  constructor() { }

  ngOnInit() {
  }

}
