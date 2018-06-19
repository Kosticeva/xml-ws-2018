import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../services/accommodation.service';
import { ReservationService } from '../services/reservation.service';
import { Accomodation } from '../model/accomodation';
import { Reservation } from '../model/reservation';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-accommodation-page',
  templateUrl: './accommodation-page.component.html',
  providers: [ AccommodationService, ReservationService ]
})
export class AccommodationPageComponent implements OnInit {

	accommodation: Accomodation;
	dateStart: Date;
	dateEnd: Date;
	price: number;
	persons: number;

	constructor(
		private accommodationService : AccommodationService,
		private reservationService : ReservationService,
		private route: ActivatedRoute
		) { }

	ngOnInit() {
		const id = +this.route.snapshot.paramMap.get('id');
		this.dateStart = this.toDate(this.route.snapshot.queryParamMap.get('datestart'));
		this.dateEnd = this.toDate(this.route.snapshot.queryParamMap.get('dateend'));
		this.persons = +this.route.snapshot.queryParamMap.get('persons');
		this.price = +this.route.snapshot.queryParamMap.get('price');
		this.getAccommodation(id);
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
	
}