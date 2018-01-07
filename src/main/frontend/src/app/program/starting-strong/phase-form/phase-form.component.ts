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
    date: null,
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

  onClickSave(): void {
    this.workout.id = null;
    this.workout.date = new Date().toDateString();
    this.service.addWorkout(this.workout).subscribe(
      (workout: StartingStrengthWorkout) => {
        this.service.onWorkoutAdded.emit(workout)
      }
    );
  }

}
