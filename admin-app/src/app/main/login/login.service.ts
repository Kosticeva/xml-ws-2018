import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SERVER_API_URL } from '../../app.constants';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  login(user: any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.post(SERVER_API_URL + '/user/login', JSON.stringify(user), httpOptions);
  }

  setUser(user: any) {
    localStorage.setItem('user', user);
  }

  getUser() {
    return localStorage.getItem('user');
  }
}
