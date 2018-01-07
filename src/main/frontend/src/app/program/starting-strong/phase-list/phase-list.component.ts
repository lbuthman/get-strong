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
  }

  getWorkouts(): void {
    this.service.getWorkouts()
      .subscribe(workouts => this.workouts = workouts,
        (error) => console.log(error),
      );
  }

}
