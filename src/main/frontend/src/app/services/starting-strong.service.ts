import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable()
export class StartingStrongService {

  private url = "/api/v1/starting-strong";

  constructor(private http: HttpClient) { }

}
