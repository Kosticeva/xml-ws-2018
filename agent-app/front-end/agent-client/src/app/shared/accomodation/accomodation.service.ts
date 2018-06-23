import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccomodationDTO } from '../../accomodation/accomodationDTO.model';

@Injectable({
  providedIn: 'root'
})
export class AccomodationService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8092/accomodation/read', { withCredentials: true });
  }

  send(accomodation: any): Observable<any> {
    return this.http.post('//localhost:8092/accomodation/create', accomodation, { withCredentials: true });
  }

  getServices(): Observable<any> {
    return this.http.get('//localhost:8092/accomodation/services', { withCredentials: true });
  }

  getTypes(): Observable<any> {
    return this.http.get('//localhost:8092/accomodation/types', { withCredentials: true });
  }

  getCategories(): Observable<any> {
    return this.http.get('//localhost:8092/accomodation/categories', { withCredentials: true });
  }

}
