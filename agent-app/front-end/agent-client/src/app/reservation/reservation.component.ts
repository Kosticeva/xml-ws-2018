import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../shared/reservation/reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  private reservations: Array<any>;

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
  }

  getReservations() {
    this.reservationService.getAll().subscribe(data => {
      this.reservations = data;
    });
  }

  approve(id: number) {
    this.reservationService.approve(id).subscribe(data => {
      this.getReservations();
    });
  }

  reject(id: number) {
    this.reservationService.reject(id).subscribe(data => {
      this.getReservations();
    });
  }

}
