package com.xml.booking.web.rest;

import com.xml.booking.domain.Review;
import com.xml.booking.dto.ReviewDTO;
import com.xml.booking.repository.AccomodationRepository;
import com.xml.booking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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
    public ResponseEntity<List<ReviewDTO>> getNotAllowedReviews(){
        return new ResponseEntity<List<ReviewDTO>>(this.reviewService.getReviewsByAllowed(false), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<ReviewDTO>> getAll() {
        return new ResponseEntity<List<ReviewDTO>>(this.reviewService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO review) throws URISyntaxException{
        if(review.getReviewId() >= 0) {
            return null;
        }

        ReviewDTO retVal = reviewService.createReview(review);
        if(retVal != null){
            return ResponseEntity.created(new
                    URI("/reviews/"+retVal.getReviewId()))
                    .body(retVal);
        }

        return null;
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ReviewDTO> editReview(@RequestBody ReviewDTO review, @PathVariable("reviewId") int reviewId) {
        if(review.getReviewId() < 0 || review.getReviewId() != reviewId) {
            return null;
        }

        ReviewDTO retVal = reviewService.editReview(review);
        if(retVal != null){
            return ResponseEntity.ok(retVal);
        }

        return null;
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.DELETE)
    public void deleteReview( @PathVariable("reviewId") int reviewId){
        reviewService.deleteReview(reviewId);
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.GET)
    public ReviewDTO getOneReview( @PathVariable("reviewId") int reviewId){
        return reviewService.getReview(reviewId);
    }

    @GET
    @Path("/accommodation/{accommodationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReviewDTO> getAllReviewsForPlace(@RequestParam int accommodationId){
        return reviewService.getAllReviewsForPlace(accommodationId);
    }

    @GET
    @Path("/accommodation/{accommodationId}/grade")
    public double calculateReview(@RequestParam int accommodationId){
        return reviewService.calculateAverageGrade(accommodationId);
    }
}
