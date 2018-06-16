import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SERVER_API_URL} from "../../app.constants";
import {User} from "../model/user";
import {HttpHeaders} from "@angular/common/http";
import {RequestOptions} from "@angular/http";

@Injectable()
export class UsersService {

  constructor(private http: HttpClient) { }

  getPendingUsers() {
    return this.http.get(SERVER_API_URL + '/user/pending', {withCredentials: true});
  }

  approveUser(u: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.put(SERVER_API_URL + '/admin/activate-user', JSON.stringify(u), httpOptions);
  }

  declineUser(u: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.put(SERVER_API_URL + '/admin/block-user', JSON.stringify(u), httpOptions);
  }
}
