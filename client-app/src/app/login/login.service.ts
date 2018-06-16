import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/finally';
import 'rxjs/add/operator/catch';

@Injectable()
export class LoginService {

	authenticated = false;

	constructor(private http: HttpClient) {
	}

	authenticate(credentials, callback, errorCallback) {
		
		const token = credentials ? btoa(credentials.username + ':' + credentials.password) : localStorage.getItem('token');
		if (token == "null") return;
		
		localStorage.setItem('token', token);
		
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + token })
		};
		
        this.http.get('http://localhost:8091/login/user', httpOptions).subscribe(response => {
            if (response['name']) {
                this.authenticated = true;
            } else {
                this.authenticated = false;
            }
            return callback && callback();
        },
		error => {
			//alert("greska!");
			return errorCallback && errorCallback();
		});

    }
	
	logout(callback) {
		this.http.get('http://localhost:8091/login/logout', {}).finally(() => {
			this.authenticated = false;
			localStorage.removeItem('token');
			return callback && callback();
		}).subscribe();
	}

}
