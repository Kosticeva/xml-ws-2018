import { Component, OnInit } from '@angular/core';
import {AccomodationService} from "../model/accomodationService";
import {AccomodationType} from "../model/accomodationType";
import {AccomService} from "./accom.service";

@Component({
  selector: 'app-accomodation',
  templateUrl: './accomodation.component.html',
  styleUrls: ['./accomodation.component.css']
})
export class AccomodationComponent implements OnInit {

  services: AccomodationService[] = [];
  types: AccomodationType[] = [];

  constructor(private accomodationService: AccomService) { }

  ngOnInit() {
    this.accomodationService.getTypes().subscribe(
      (data: any) => {
        this.types= data;
      }
    );

    this.accomodationService.getServices().subscribe(
      (data: any) => {
        this.services = data;
      }
    );
  }

  deleteService(s: AccomodationService) {
    var r = confirm("Are u sure?");
    if (r == true) {
      this.accomodationService.deleteService(s.serviceID).subscribe(
        (data) => {
          this.services.splice(this.services.indexOf(s), 1);
        }
      );
    }
  }

  deleteType(t: AccomodationType) {
    var r = confirm("Are u sure?");
    if (r == true) {
      this.accomodationService.deleteType(t.typeID).subscribe(
        (data) => {
          this.types.splice(this.types.indexOf(t), 1);
        }
      );
    }
  }

}
