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
	
	getReservationsForUserActive(username: string) : Observable<Reservation[]>  {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<Reservation[]>(`http://localhost:8091/reservation/getbyuseractive/${username}`, httpOptions);
	}
	getReservationsForUserInActive(username: string) : Observable<Reservation[]>  {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<Reservation[]>(`http://localhost:8091/reservation/getbyuserinactive/${username}`, httpOptions);
	}
	getReservationsForUserRealized(username: string) : Observable<Reservation[]>  {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<Reservation[]>(`http://localhost:8091/reservation/getbyuserrealized/${username}`, httpOptions);
	}
	
	cancelReservation(reservationId: number, callback, errorCallback) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.put(`http://localhost:8091/reservation/cancel/${reservationId}`, httpOptions).subscribe(
		response => {
			return callback && callback();
        },
		error => {
			return errorCallback && errorCallback();
		});;
	}
	activateReservation(reservationId: number, callback, errorCallback) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.put(`http://localhost:8091/reservation/activate/${reservationId}`, httpOptions).subscribe(
		response => {
			return callback && callback();
        },
		error => {
			return errorCallback && errorCallback();
		});;
	}
  
}
