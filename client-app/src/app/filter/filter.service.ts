import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class FilterService {

  constructor(
    private http: HttpClient
  ) { }

  public getTypes(): any{
    return this.http.get('http://localhost:8091/accomodation-type');
  }

  public getServices(): any{
    return this.http.get('http://localhost:8091/accomodation-service');
  }

  public getCategories(): any{
    return this.http.get('http://localhost:8091/NEKIENDPOINTKADMILJANAZAVRSI');
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
    ));
  }

  public doAdvancedSearch(query: any): any{
    return this.http.put('http://localhost:8091/search/advanced', JSON.stringify(query));
  }

  public getLocations(query: string): any{
    return this.http.get('http://localhost:8091/locations?query='+query);
  }

}
