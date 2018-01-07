import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class StartingStrongService {

  private url = "/api/v1/starting-strong";

  constructor(private http: HttpClient) { }

  getWorkouts(): Observable<any> {
    return this.http.get(this.url);
  }

  getMostRecentWorkout(): Observable<any> {
    return this.http.get(this.url + "/most-recent");
  }
}
