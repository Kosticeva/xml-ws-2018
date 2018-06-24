import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8092/reservation/read', { withCredentials: true });
  }

  approve(id): Observable<any> {
    return this.http.get('//localhost:8092/reservation/approve/' + id, { withCredentials: true });
  }

  reject(id): Observable<any> {
    return this.http.get('//localhost:8092/reservation/reject/' + id, { withCredentials: true });
  }
  
  reserve(reservation): Observable<any>{
    return this.http.post('//localhost:8092/reservation/create', reservation, { withCredentials: true });
  }
}
