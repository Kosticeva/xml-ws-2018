import { Component, OnInit, Input } from '@angular/core';
import { Accomodation } from '../model/accomodation';

@Component({
  selector: 'app-accommodation',
  templateUrl: './accommodation.component.html',
  styleUrls: ['./accommodation.component.css']
})
export class AccommodationComponent implements OnInit {

  @Input() accomodations: Accomodation[];

  constructor() { }

  ngOnInit() {
  }

}
