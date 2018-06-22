import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
    
  }

  login(loginDTO): Observable<any> {
    return this.http.post('//localhost:8092/api/login', loginDTO, { withCredentials: true });
  }

  logout(): Observable<any> {
    return this.http.post('//localhost:8092/api/logout', undefined, { withCredentials: true });
  }
  
}
