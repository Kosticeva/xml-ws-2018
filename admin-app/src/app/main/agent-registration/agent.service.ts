import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Agent} from "../model/agent";
import {HttpHeaders} from "@angular/common/http";
import {SERVER_API_URL} from "../../app.constants";

@Injectable()
export class AgentService {

  constructor(private http: HttpClient) { }

  registerAgent(agent: Agent) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.post(SERVER_API_URL + '/admin/create-agent', JSON.stringify(agent), httpOptions);
  }
}
