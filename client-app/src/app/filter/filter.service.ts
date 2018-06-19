import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class FilterService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient
  ) { }

  public getTypes(): any{
    return this.http.get('http://localhost:8091/accomodation-type', this.httpOptions);
  }

  public getServices(): any{
    return this.http.get('http://localhost:8091/accomodation-service',this.httpOptions);
  }

  public getCategories(): any{
    return this.http.get('http://localhost:8091/NEKIENDPOINTKADMILJANAZAVRSI',this.httpOptions);
  }

  public doSearch(query: any): any{
    return this.http.put('http://localhost:8091/search', JSON.stringify(
      {
        'address': query.address,
        'city': query.city,
        'country': query.country,
        'dateOfArrival': query.dateOfArrival,
        'dateOfReturn': query.dateOfReturn,
        'persons': query.persons
      }
    ), this.httpOptions);
  }

  public doAdvancedSearch(query: any): any{
    return this.http.put('http://localhost:8091/search/advanced', JSON.stringify(query), this.httpOptions);
  }

  public getLocations(query: string): any{
    return this.http.get('http://localhost:8091/locations?query='+query, this.httpOptions);
  }

}
