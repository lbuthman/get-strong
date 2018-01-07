import { Component, OnInit } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";

@Component({
  selector: 'phase3',
  templateUrl: './phase3.component.html',
  styleUrls: ['./phase3.component.css']
})
export class Phase3Component implements OnInit {

  phase: String = "phase3";

  constructor() { }

  ngOnInit() {
  }

}
