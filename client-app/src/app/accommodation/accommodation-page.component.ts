import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../services/accommodation.service';
import { ReservationService } from '../services/reservation.service';
import { LoginService } from '../login/login.service';
import { Accomodation } from '../model/accomodation';
import { Reservation } from '../model/reservation';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-accommodation-page',
  templateUrl: './accommodation-page.component.html',
  styleUrls: ['./accommodation-page.component.css'],
  providers: [ AccommodationService, ReservationService ]
})
export class AccommodationPageComponent implements OnInit {

	accommodation: Accomodation;
	dateStart: Date;
	dateEnd: Date;
	price: number;
	persons: number;
	images: {
		link: string,
		id: number
	}[];

	reviews: {
		user: string,
		comment: string,
		grade: number,
		approved: boolean
	}[];
	currPic: number;
	filterGrade: number;

	constructor(
		private accommodationService : AccommodationService,
		private reservationService : ReservationService,
		private route: ActivatedRoute,
		private login : LoginService,
		private location : Location
		) { }

	ngOnInit() {
		this.filterGrade = 0;
		const id = +this.route.snapshot.paramMap.get('id');
		this.dateStart = this.toDate(this.route.snapshot.queryParamMap.get('datestart'));
		this.dateEnd = this.toDate(this.route.snapshot.queryParamMap.get('dateend'));
		this.persons = +this.route.snapshot.queryParamMap.get('persons');
		this.price = +this.route.snapshot.queryParamMap.get('price');
		this.getAccommodation(id);
		this.images = [];
		this.reviews = [];
	}

	getHref(): string{
		return window.location.href.split('#')[0];
	}

	getAccommodation(id) {
		this.accommodationService.getAccommodation(id).subscribe(accommodation => this.accommodation = accommodation);
	}
	
	createReservation() {
		let reservation = new Reservation();
		reservation.accomodationId = this.accommodation.id;
		reservation.numPersons = this.persons;
		reservation.finalPrice = this.price;
		reservation.startDate = this.dateStart;
		reservation.endDate = this.dateEnd;
		this.reservationService.createReservation(
			reservation,
			() => {/*success*/ alert('Rezervacija napravljena!')},
			() => {/*fail*/ alert('Doslo je do greske pri pravljenju rezervacije...')}
		);
	}
	//private
	toDate(datum: string) {
		const parts = datum.split('-');
		return new Date(+parts[0], +parts[1] - 1, +parts[2]);
	}

	nextPic(){
		if(this.currPic === this.images.length - 1){
		  this.currPic = 0;
		}else{
		  this.currPic += 1;
		}
	  }
	
	  prevPic(){
		if(this.currPic === 0){
		  this.currPic = this.images.length -1;
		}else{
		  this.currPic -=1;
		}
	  }
	
	  goToImage(id: number){
		this.currPic = id;
	  }
	
	filterGrades(){
		this.reviews = [];
		this.accommodationService.getReviewByGrade(this.accommodation.id, this.filterGrade).subscribe(
			(data) => {
				this.reviews = data;
			}
		)
	}

	loadReviews(){
		this.reviews = [];
		this.accommodationService.getReviews(this.accommodation.id).subscribe(
			(data) => {
				this.reviews = data
			}
		)
	}
	
	authenticated() {
		return this.login.authenticated;
	}
}