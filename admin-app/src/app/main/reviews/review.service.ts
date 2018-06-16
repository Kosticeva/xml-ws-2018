import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SERVER_API_URL} from "../../app.constants";
import {Review} from "../model/review";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class ReviewService {

  constructor(private http: HttpClient) { }

  getNotAllowed() {
    return this.http.get(SERVER_API_URL + '/reviews/not-allowed', {withCredentials: true});
  }

  publish(review: Review) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.put(SERVER_API_URL + '/admin/allow-review', JSON.stringify(review), httpOptions);
  }

  decline(review: Review){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.put(SERVER_API_URL + '/admin/decline-review', JSON.stringify(review), httpOptions);
  }
}
