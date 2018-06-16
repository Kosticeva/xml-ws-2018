import { Component, OnInit } from '@angular/core';
import {AccomService} from "../accom.service";
import {Router} from "@angular/router";
import {AccomodationService} from "../../model/accomodationService";

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css']
})
export class AddServiceComponent implements OnInit {

  constructor(private accomService: AccomService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(as: AccomodationService) {
    this.accomService.addService(as).subscribe(
      (data) => {
        alert("Successfully created service");
        this.router.navigateByUrl('/home/accomodation');
      }
    );
  }
}
