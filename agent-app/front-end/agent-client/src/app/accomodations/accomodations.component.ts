import { Component, OnInit } from '@angular/core';
import { AccomodationService } from '../shared/accomodation/accomodation.service';

@Component({
  selector: 'app-accomodations',
  templateUrl: './accomodations.component.html',
  styleUrls: ['./accomodations.component.css']
})
export class AccomodationsComponent implements OnInit {

  accomodations: any[];

  constructor(private accomodationService: AccomodationService) { }

  ngOnInit() {
    this.getAccomodations();
  }

  getAccomodations() {
    this.accomodationService.getAll().subscribe(data => {
      this.accomodations = data;
    });
  }

}
