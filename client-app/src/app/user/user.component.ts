import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { ReservationService } from '../services/reservation.service';
import { User } from '../model/user';
import { Reservation } from '../model/reservation';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [ UserService, ReservationService ]
})
export class UserComponent implements OnInit {

	user : User;
	reservationsActive : Reservation[];
	reservationsInactive : Reservation[];
	reservationsRealized : Reservation[];

	constructor(private userService : UserService, private reservationService : ReservationService) { }

	ngOnInit() {
		this.getProfileData();
		
	}

	getProfileData() {
		this.userService.getUser().subscribe(u => { this.user = u; this.getReservations() });
	}
	
	getReservations() {
		this.reservationService.getReservationsForUserActive(this.user.username).subscribe(ress => this.reservationsActive = ress);
		this.reservationService.getReservationsForUserInActive(this.user.username).subscribe(ress => this.reservationsInactive = ress);
		this.reservationService.getReservationsForUserRealized(this.user.username).subscribe(ress => this.reservationsRealized = ress);
	}
	
	cancelReservation(reservationId : number) {
		this.reservationService.cancelReservation(
			reservationId,
			() => { this.getReservations() },
			() => {/*error*/}
		);
	}
	activateReservation(reservationId : number) {
		this.reservationService.activateReservation(
			reservationId,
			() => { this.getReservations() },
			() => {/*error*/}
		);
	}
}
