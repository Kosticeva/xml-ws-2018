import { Injectable } from '@angular/core';
import { Accomodation } from '../model/accomodation';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AccommodationService {

	constructor(private http: HttpClient) { }
  
	getAccommodation(id: number) : Observable<Accomodation> {
		/*const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};*/
		return this.http.get<Accomodation>(`http://localhost:8091/accommodation/get/${id}`/*, httpOptions*/);
	}

	getImages(id: number): Observable<any>{
		return this.http.get('http://localhost:8091/accommodation/get/images/'+id);
	}
  
	getReviewByGrade(accId: number, value: number): Observable<any> {
		return this.http.get(`http://localhost:8091/reviews/accommodation/`+accId+`/grade/`+value);
	}

	getReviews(accId: number): Observable<any>{
		return this.http.get(`http://localhost:8091/reviews/accommodation/`+accId);
	}
}
