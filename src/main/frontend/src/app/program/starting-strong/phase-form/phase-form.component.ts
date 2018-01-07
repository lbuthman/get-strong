import { Component, OnInit, Input } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";
import {StartingStrongService} from "../../../services/starting-strong.service";

@Component({
  selector: 'phase-form',
  templateUrl: './phase-form.component.html',
  styleUrls: ['./phase-form.component.css']
})
export class PhaseFormComponent implements OnInit {

  workout: StartingStrengthWorkout = {
    id: null,
    squat: 0,
    press: 0,
    benchPress: 0,
    deadLift: 0,
    powerClean: 0,
    pullUp: 0,
    date: new Date().getDate().toString(),
  };

  @Input() phase: string = "phase3";

  selectedWorkout: string = "A";

  constructor(private service: StartingStrongService) { }

  ngOnInit() {
    this.setWorkout();
  }

  setWorkout() {
    this.service.getMostRecentWorkout().subscribe(
      workout => this.workout = workout,
      (error) => console.log(error)
    );
  }

  onClickSave() {
    this.workout.id = null;
    console.log(this.workout);
  }

}
