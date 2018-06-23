import { Component, OnInit } from '@angular/core';
import { AccomodationDTO } from './accomodationDTO.model';
import { AccomodationService } from '../shared/accomodation/accomodation.service';

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

  constructor(private accomodationService: AccomodationService) {
    this.accomodationDTO = new AccomodationDTO();
  }

  ngOnInit() {
    this.accomodationService.getServices().subscribe(data => {
      this.services = data;
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
    this.accomodationService.send(this.accomodationDTO).subscribe(data => {
      alert("DONE!");
    });
  }

  handleFileInput(files: FileList) {
    for(let i = 0; i < files.length; i++) {
      var reader = new FileReader();
      reader.onload = (event:any) => {
        this.accomodationDTO.images.push(event.target.result);
      }
      reader.readAsDataURL(files.item(i));
    }
  }

}