import { Injectable } from '@angular/core';
import { Reservation } from '../model/reservation';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ReservationService {

	constructor(private http: HttpClient) { }
  
	createReservation(reservation: Reservation, callback, errorCallback) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.post(`http://localhost:8091/reservation/create`, reservation, httpOptions).subscribe(
		response => {
			return callback && callback();
        },
		error => {
			return errorCallback && errorCallback();
		});
	}
  
}
