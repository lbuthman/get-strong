import {AfterContentInit, Component, OnInit} from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";
import {StartingStrongService} from "../../../services/starting-strong.service";

@Component({
  selector: 'phase1',
  templateUrl: './phase1.component.html',
  styleUrls: ['./phase1.component.css']
})
export class Phase1Component implements OnInit {

  phase: String = "phase1";

  constructor() { }

  ngOnInit() {

  }
}
