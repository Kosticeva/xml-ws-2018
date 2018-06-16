import { Component, OnInit } from '@angular/core';
import {Review} from "../model/review";
import {ReviewService} from "./review.service";

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  reviews: Review[] = [];

  constructor(private reviewService: ReviewService) { }

  ngOnInit() {
    this.reviewService.getNotAllowed().subscribe(
      (data: any) => {
        this.reviews = data;
      }
    );
  }

  publish(review: Review) {
    var r = confirm("Are u sure?");
    if (r == true) {
      this.reviewService.publish(review).subscribe(
        (data: Review) => {
          this.reviews.splice(this.reviews.indexOf(review), 1);
        }
      );
    }
  }

  decline(review: Review) {
    var r = confirm("Are u sure?");
    if (r == true) {
      this.reviewService.decline(review).subscribe(
        (data: Review) => {
          this.reviews.splice(this.reviews.indexOf(review), 1);
        }
      );
    }
  }
}
