import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccomodationDTO } from '../../accomodation/accomodationDTO.model';

@Injectable({
  providedIn: 'root'
})
export class AccomodationService {

  constructor(private http: HttpClient) { }

  send(accomodation: any): Observable<any> {
    return this.http.post('//localhost:8092/accomodation/create', accomodation, { withCredentials: true });
  }
}
