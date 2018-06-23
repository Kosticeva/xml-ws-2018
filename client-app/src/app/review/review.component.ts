import { Component, OnInit } from '@angular/core';
import { Review } from '../model/review';
import { Accomodation } from '../model/accomodation';
import { AccommodationService } from '../services/accommodation.service';
import { ReviewService } from '../services/review.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css'],
  providers: [ AccommodationService, ReviewService ]
})
export class ReviewComponent implements OnInit {

	review: Review = new Review();
	accomodation : Accomodation;

	constructor(
		private accommodationService : AccommodationService,
		private route: ActivatedRoute,
		private location : Location,
		private reviewService : ReviewService,
		private router : Router
		) { }

	ngOnInit() {

		this.accommodationService.getAccommodation(+this.route.snapshot.paramMap.get('id')).subscribe(acco => this.accomodation = acco);
	}
	
	postReview() {
		this.review.accomodationId = this.accomodation.id;
		this.reviewService.postReview(
			this.review,
			() => { 
				alert('Ocenjen!');
				this.router.navigateByUrl("/user");
			},
			() => { /*nesto puklo*/ });
	}

}
