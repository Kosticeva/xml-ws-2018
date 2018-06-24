import { Component, OnInit } from '@angular/core';
import { AccomodationDTO } from './accomodationDTO.model';
import { AccomodationService } from '../shared/accomodation/accomodation.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accomodation',
  templateUrl: './accomodation.component.html',
  styleUrls: ['./accomodation.component.css']
})
export class AccomodationComponent implements OnInit {

  accomodationDTO: AccomodationDTO;

  services: any[];
  types: any[];
  categories: any[];

  response: string;

  constructor(
    private accomodationService: AccomodationService,
    private router: Router
  ) {
    this.accomodationDTO = new AccomodationDTO();
  }

  ngOnInit() {
    this.accomodationService.getServices().subscribe(data => {
      this.services = data;
      this.services.forEach(service => {
        service['checkboxValue'] = false;
      });
      console.log(this.services);
    });
    this.accomodationService.getTypes().subscribe(data => {
      this.types = data;
      console.log(this.types);
    });
    this.accomodationService.getCategories().subscribe(data => {
      this.categories = data;
      console.log(this.categories);
    });
  }

  send() {
    this.services.forEach(service => {
      if(service.checkboxValue === true) {
        this.accomodationDTO.services.push(service.serviceID);
      }
    });

    if(this.accomodationDTO.images.length < 1) {
      this.response = "Select atleast 1 picture";
      return;
    }

    this.accomodationService.send(this.accomodationDTO).subscribe(data => {
      this.router.navigate(['/accomodations']);
    });
  }

  handleFileInput(files: FileList) {
    if(files.length > 0) {
      this.response = '';
    }
    else {
      this.response = 'Select atleast 1 picture';
    }
    for(let i = 0; i < files.length; i++) {
      var reader = new FileReader();
      reader.onload = (event:any) => {
        this.accomodationDTO.images.push(event.target.result);
      }
      reader.readAsDataURL(files.item(i));
    }
  }

}
