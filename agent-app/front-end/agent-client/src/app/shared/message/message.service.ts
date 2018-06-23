import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  send(message: any): Observable<any> {
    return this.http.post('//localhost:8092/message/create', message, { withCredentials: true });
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8092/message/read', { withCredentials: true });
  }

  get(id: number): Observable<any> {
    return this.http.get('//localhost:8092/message/read/' + id, { withCredentials: true });
  }

  seen(id: number): Observable<any> {
    return this.http.get('//localhost:8092/message/seen/' + id, { withCredentials: true });
  }

}
