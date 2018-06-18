import { Injectable } from '@angular/core';
import { Message } from '../model/message';
import { Agent } from '../model/agent';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class MessagesService {

  constructor(private http: HttpClient) { }
  
	getMessages(agentUsername: string) : Observable<Message[]> {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<Message[]>(`http://localhost:8091/messages/getconversation/${agentUsername}`, httpOptions);
	}

	getAgents() : Observable<Agent[]> {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.get<Agent[]>(`http://localhost:8091/messages/getagents`, httpOptions);
	}
	
	sendMessage(message: Message, callback, errorCallback) {
		const httpOptions = {
			headers: new HttpHeaders({ 'Authorization': 'Basic ' + localStorage.getItem('token') })
		};
		return this.http.post(`http://localhost:8091/messages/sendtoagent`, message, httpOptions).subscribe(
		response => {
			return callback && callback();
        },
		error => {
			return errorCallback && errorCallback();
		});
;
	}
  
}
