import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/finally';
import 'rxjs/add/operator/catch';

@Injectable()
export class RegisterService {

	
	constructor(private http: HttpClient) {
	}

	register(user, callback, errorCallback) {
		
		
        this.http.post('http://localhost:8091/register/register', user, {}).subscribe(
		response => {
			return callback && callback();
        },
		error => {
			return errorCallback && errorCallback();
		});

    }
	

}
