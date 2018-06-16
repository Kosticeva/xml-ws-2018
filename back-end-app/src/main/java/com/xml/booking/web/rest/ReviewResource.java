package com.xml.booking.web.rest;

import com.xml.booking.domain.Review;
import com.xml.booking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class ReviewResource {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/not-allowed")
    public ResponseEntity<List<Review>> getNotAllowedReviews(){
        return new ResponseEntity<List<Review>>(this.reviewService.getReviewsByAllowed(false), HttpStatus.OK);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Review>> getAll() {
        return new ResponseEntity<List<Review>>(this.reviewService.getAll(), HttpStatus.OK);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Review> createReview(@RequestBody Review review) throws URISyntaxException{
        if(review.getReviewId() >= 0) {
            return null;
        }

        Review retVal = reviewService.createReview(review);
        if(retVal != null){
            return ResponseEntity.created(new
                    URI("/reviews/"+retVal.getReviewId()))
                    .body(retVal);
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{reviewId}")
    public ResponseEntity<Review> editReview(@RequestBody Review review, @RequestParam int reviewId) {
        if(review.getReviewId() < 0 || review.getReviewId() != reviewId) {
            return null;
        }

        Review retVal = reviewService.editReview(review);
        if(retVal != null){
            return ResponseEntity.ok(retVal);
        }

        return null;
    }

    @DELETE
    @Path("/{reviewId}")
    public void deleteReview(@RequestParam int reviewId){
        reviewService.deleteReview(reviewId);
    }

    @GET
    @Path("/{reviewId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review getOneReview(@RequestParam int reviewId){
        return reviewService.getReview(reviewId);
    }

    @GET
    @Path("/accommodation/{accommodationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> getAllReviewsForPlace(@RequestParam int accommodationId){
        return reviewService.getAllReviewsForPlace(accommodationId);
    }

    @GET
    @Path("/accommodation/{accommodationId}/grade")
    public double calculateReview(@RequestParam int accommodationId){
        return reviewService.calculateAverageGrade(accommodationId);
    }
}
