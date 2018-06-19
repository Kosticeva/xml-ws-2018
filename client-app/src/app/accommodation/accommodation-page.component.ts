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
		//this.getAccommodation(id);
		this.accommodation = {
			id: 2,
			address: "Bulevar Oslobodjenja 109",
			agentUsername: "Kosticeva",
			averageGrade: 3.9,
			category: "2 zvezdice",
			city: "Novi Sad",
			country: "Srbija",
			description: "Ovo je neki opis, tra la alasda ds qw qw   s fa fqw 2 wqf  31r 13rf w fsdf sd f g2n4rn fdg g dfgw gew  vs df df ds fs dfsd o je neki opis, tra la alasda ds qw qw   s fa fqw 2 wqf  31r 13rf w fsdf sd f g2n4rn fdg g dfgw gew  vs df df ds fs dfsd o je neki opis, tra la alasda ds qw qw   s fa fqw 2 wqf  31r 13rf w fsdf sd f g2n4rn fdg g dfgw gew  vs df df ds fs dfsd o je neki opis, tra la alasda ds qw qw   s fa fqw 2 wqf  31r 13rf w fsdf sd f g2n4rn fdg g dfgw gew  vs df df ds fs dfsd o je neki opis, tra la alasda ds qw qw   s fa fqw 2 wqf  31r 13rf w fsdf sd f g2n4rn fdg g dfgw gew  vs df df ds fs dfsd",
			name: "Garni Hostel",
			price: 15627,
			type: "Hostel",
			services: [
			  "Wi-Fi",
			  "TV",
			  "Klima",
			  "Besplatan parking"
			],
			days: 0,
			persons: 0
		  };
	  
		  this.reviews = [
			{
			  user: "Jelena",
			  comment: "FUJ ODVRATNO BUBASVABE SVUDA",
			  grade: 1,
			  approved: true
			},
			{
			  user: "Mika",
			  comment: "Bas je ok, ne znam o cemu ljudi pricaju",
			  grade: 5,
			  approved: false
			}
		  ];
		  this.currPic = 0;
		  this.images = [
			{
			  link: 'https://ihg.scene7.com/is/image/ihg/even-hotels-2018-campaign-h6',
			  id: 0
			},
			{
			  link: 'https://ihg.scene7.com/is/image/ihg/Brand-Home_Desktop_Image-5-Travel-fit-even-during-downtime-with-EVEN-Hotels-Premium-Bedding@2x',
			  id: 1
			},
			{
			  link: 'http://www.hotel-grandium.cz/files/hotel/grandior-hotel-prague/Yasmin_Lobby_FO_1.jpg',
			  id: 2
			},
			{
			  link: 'https://www.corinthia.com/application/files/6315/0460/7084/corinthia-hotel-tripoli-lobby.jpg',
			  id: 3
			},
			{
			  link: 'https://ambassade-hotel.nl/wp-content/uploads/2015/11/Ambassade-Hotel-Canalside-Superior-Deluxe-3a-1030x686.jpg',
			  id: 4
			},
			{
			  link: 'https://www.thonhotels.com/siteassets/hoteller/belgia/brussel/thon-hotel-bristol-stephanie/thon-hotel-bristol-stephanie-lobby-2.jpg',
			  id: 5
			},
			{
			  link: 'https://www.danubiushotels.com/w/accomms/0_1000/0/any/Hotel-Flamenco-Budapest-swimming-pool-maxi929.jpg',
			  id: 6
			}
		  ];
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
	
}