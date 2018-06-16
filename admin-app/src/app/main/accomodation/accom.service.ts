import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SERVER_API_URL} from "../../app.constants";
import {AccomodationType} from "../model/accomodationType";
import {HttpHeaders} from "@angular/common/http";
import {AccomodationService} from "../model/accomodationService";

@Injectable()
export class AccomService {

  constructor(private http: HttpClient) { }

  getServices() {
    return this.http.get(SERVER_API_URL + '/accomodation-service', {withCredentials: true});
  }

  getTypes() {
    return this.http.get(SERVER_API_URL + '/accomodation-type', {withCredentials: true});
  }

  addType(at: AccomodationType) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.post(SERVER_API_URL + '/accomodation-type', JSON.stringify(at), httpOptions);
  }

  addService(as: AccomodationService) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.post(SERVER_API_URL + '/accomodation-service', JSON.stringify(as), httpOptions);
  }

  deleteService(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.delete(SERVER_API_URL + '/accomodation-service/'+id, httpOptions);
  }

  deleteType(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    return this.http.delete(SERVER_API_URL + '/accomodation-type/'+id, httpOptions);
  }
}
