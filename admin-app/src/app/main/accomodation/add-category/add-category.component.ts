import { Component, OnInit } from '@angular/core';
import { AccomService } from '../accom.service';
import { Router } from '@angular/router';
import { AccomodationCategory } from '../../model/accomodationCategory';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  constructor(private accomService: AccomService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(ac: AccomodationCategory) {
    this.accomService.addCategory(ac).subscribe(
      (data) => {
        alert("Successfully created category");
        this.router.navigateByUrl('/home/accomodation');
      }
    );
  }

}
