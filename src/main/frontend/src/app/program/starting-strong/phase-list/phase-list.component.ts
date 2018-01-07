import { Component, OnInit, Input } from '@angular/core';
import {StartingStrengthWorkout} from "../startingStrengthWorkout";
import {StartingStrongService} from "../../../services/starting-strong.service";

@Component({
  selector: 'phase-list',
  templateUrl: './phase-list.component.html',
  styleUrls: ['./phase-list.component.css']
})
export class PhaseListComponent implements OnInit {

  workouts: StartingStrengthWorkout[];

  @Input() phase: string = "phase1";

  constructor(private service: StartingStrongService) { }

  ngOnInit() {
    this.getWorkouts();

    this.service.onWorkoutAdded.subscribe(
      (workout: StartingStrengthWorkout) => this.workouts.unshift(workout)
    );
  }

  getWorkouts(): void {
    this.service.getWorkouts()
      .subscribe(workouts => this.workouts = workouts,
        (error) => console.log(error),
      );
  }

  onClickDelete(id: number): void {
    this.service.deleteWorkout(id)
      .subscribe(() => {
          this.workouts.splice(id, 1);
        }
      );
  }

}
