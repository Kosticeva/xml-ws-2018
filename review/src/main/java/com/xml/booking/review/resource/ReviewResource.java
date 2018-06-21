package com.xml.booking.review.resource;

import com.xml.booking.review.dto.Review;
import com.xml.booking.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8091", maxAge = 3600)
@RequestMapping("/reviews")
public class ReviewResource {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/not-allowed", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Review> getNotAllowedReviews(){
        System.out.println("Review: not allowed");
        return this.reviewService.getReviewsByAllowed(false);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Review> getAll() {
        System.out.println("Review: all");
        return this.reviewService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Review createReview(@RequestBody Review review) throws URISyntaxException {
        System.out.println("Review: create");
        if(review.getReviewId() != null) {
            return null;
        }

        Review retVal = reviewService.createReview(review);
        if(retVal != null){
            return retVal;
        }

        return null;
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Review editReview(@RequestBody Review review, @PathVariable("reviewId") int reviewId) {
        System.out.println("Review: update");
        if(review.getReviewId() < 0 || review.getReviewId() != reviewId) {
            return null;
        }

        Review retVal = reviewService.editReview(review);
        if(retVal != null){
            return retVal;
        }

        return null;
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.DELETE)
    public void deleteReview( @PathVariable("reviewId") int reviewId){
        System.out.println("Review: delete");
        reviewService.deleteReview(reviewId);
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Review getOneReview( @PathVariable("reviewId") int reviewId){
        System.out.println("Review: one");
        return reviewService.getReview(reviewId);
    }

    @RequestMapping(value = "/accommodation/{accommodationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Review> getAllReviewsForPlace(@PathVariable("accommodationId") int accommodationId){
        System.out.println("Review: all for place");
        return reviewService.getAllReviewsForPlace(accommodationId);
    }

    @RequestMapping(value = "/accommodation/{accommodationId}/grade", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public double calculateReview(@PathVariable("accommodationId") int accommodationId){
        System.out.println("Review: grade for place");
        return reviewService.calculateAverageGrade(accommodationId);
    }

    @RequestMapping(value = "/accommodation/{accommodationId}/grade/{gradeVal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Review> getAllGradesWithValueForAccomodation(@PathVariable("accommodationId") Integer accId, @PathVariable("gradeVal") Integer gradeVal){
        System.out.println("Review: grade "+gradeVal+" for place");
        return reviewService.getAllReviewsForPlaceByGrade(accId, gradeVal);
    }

    @RequestMapping(value = "/allow", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public Review allowReview(@RequestBody Review review){
        return reviewService.allowReview(review, true);
    }

    @RequestMapping(value = "/decline", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public Review declineReview(@RequestBody Review review){
        return reviewService.allowReview(review, false);
    }
}
