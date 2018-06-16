import { Component, OnInit } from '@angular/core';
import {AccomService} from "../accom.service";
import {AccomodationType} from "../../model/accomodationType";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-type',
  templateUrl: './add-type.component.html',
  styleUrls: ['./add-type.component.css']
})
export class AddTypeComponent implements OnInit {

  constructor(private accomService: AccomService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(at: AccomodationType) {
    this.accomService.addType(at).subscribe(
      (data) => {
        alert("Successful created type");
        this.router.navigateByUrl('/home/accomodation');
      }
    );
  }
}
