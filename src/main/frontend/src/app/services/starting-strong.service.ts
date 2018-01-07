import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {StartingStrengthWorkout} from "../program/starting-strong/startingStrengthWorkout";

@Injectable()
export class StartingStrongService {

  private url = "/api/v1/starting-strong";

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  onWorkoutAdded = new EventEmitter<StartingStrengthWorkout>();

  constructor(private http: HttpClient) { }

  getWorkouts(): Observable<any> {
    return this.http.get(this.url);
  }

  getMostRecentWorkout(): Observable<any> {
    return this.http.get(this.url + "/most-recent");
  }

  addWorkout(workout: StartingStrengthWorkout) {
    return this.http.post(this.url, workout, this.httpOptions);
  }

  deleteWorkout(id: number) {
    let url = this.url + "/" + id;
    return this.http.delete(url);
  }
}
