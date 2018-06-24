import { Component, OnInit } from '@angular/core';
import { Reservation } from './reservation.model';
import { ReservationService } from '../shared/reservation/reservation.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.css']
})
export class CreateReservationComponent implements OnInit {

  reservation: Reservation;

  constructor(
    private reservationService: ReservationService,
    private router: Router
  ) {
    this.reservation = new Reservation();
  }

  ngOnInit() {
  }

  reserve() {
    this.reservationService.reserve(this.reservation).subscribe(data => {
      this.router.navigate(['/reservations']);
    });
  }

}
