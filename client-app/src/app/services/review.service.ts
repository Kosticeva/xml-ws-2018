import { Injectable } from '@angular/core';
import { Review } from '../model/review';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ReviewService {

  constructor(private http: HttpClient) { }
  
	//ovo se nigde ne koristi, zapravo i nema ove fje na bekendu
	getReviews(accomodationId: number) : Observable<Review[]> {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<Review[]>(`http://localhost:8091/reviews/getReviewsForAccomodation/${accomodationId}`, httpOptions);
	}

	postReview(review: Review, callback, errorCallback) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.post(`http://localhost:8091/reviews`, review, httpOptions).subscribe(
		response => {
			return callback && callback();
        },
		error => {
			return errorCallback && errorCallback();
		});
;
	}
  
}
