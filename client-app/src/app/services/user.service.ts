import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

	constructor(private http: HttpClient) { }
  
	getUser() : Observable<User> {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<User>(`http://localhost:8091/user/get`, httpOptions);
	}
  
}
