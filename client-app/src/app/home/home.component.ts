import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service'
import { Router } from '@angular/router'
import { Accomodation } from '../model/accomodation';
import { QueryShareService } from '../services/queryshare.service';
import { isNumber } from 'util';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ LoginService ]
})
export class HomeComponent implements OnInit {

	accomodations: Accomodation[];
  filters: {
		name: string,
		type: number
	}[];

  constructor(private queryShareService : QueryShareService) { }

	ngOnInit() {
		this.accomodations = [];
		this.filters = [];
	}
  
	getStartDate() {
		return this.queryShareService.getQuery().dateOfArrival;
	}
	getEndDate() {
		return this.queryShareService.getQuery().dateOfReturn;
	}
	getPersons() {
		return this.queryShareService.getQuery().persons;
	}

	sortByGrade(flag: boolean){
		if(flag)
			this.accomodations.sort((n1, n2) => this.compareGrade(n1, n2));
		else
			this.accomodations.sort((n1, n2) => this.compareGrade(n2, n1));
	}

	compareGrade(n1: Accomodation, n2: Accomodation): number{
		if(n1.averageGrade > n2.averageGrade){
			return 1;
		} else if(n1.averageGrade < n2.averageGrade){
			return -1;
		}

		return 0;
	}

	sortByPrice(flag: boolean){
		if(flag)
			this.accomodations.sort((n1, n2) => this.comparePrice(n1, n2));
		else
			this.accomodations.sort((n1, n2) => this.comparePrice(n2, n1));
	}

	comparePrice(n1: Accomodation, n2: Accomodation): number{
		if(n1.price > n2.price){
			return 1;
		} else if(n1.price < n2.price){
			return -1;
		}

		return 0;
	}

	sortByCat(flag: boolean){
		if(flag)
			this.accomodations.sort((n1, n2) => this.compareCategory(n1, n2));
		else
			this.accomodations.sort((n1, n2) => this.compareCategory(n2, n1));
	}

	compareCategory(n1: Accomodation, n2: Accomodation): number{
		let zv = n1.categoryName.split(' ');
		let v1 = Number(zv[0]);
		if(isNaN(v1)){
			v1 = 0;
		}

		zv = n2.categoryName.split(' ');
		let v2 = Number(zv[0]);
		if(isNaN(v2)){
			v2 = 0;
		}

		if(v1 > v2){
			return 1;
		}else if(v1 < v2){
			return -1;
		}

		return 0;
	}

}
