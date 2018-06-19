import { Injectable } from '@angular/core';

@Injectable()
export class QueryShareService {

	query;

	constructor() { }
	
	setQuery(query : any) {
		this.query = query;
	}
	
	getQuery():any {
		return this.query;
	}
  
}
