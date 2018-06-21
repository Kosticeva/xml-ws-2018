package com.xml.booking.web.rest;

import com.xml.booking.domain.Review;
import com.xml.booking.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class ReviewResource {

    RestTemplate restTemplate;

    public ReviewResource(){
        restTemplate = new RestTemplate();
    }

    @RequestMapping(value = "/not-allowed", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<ReviewDTO>> getNotAllowedReviews(){
        System.out.println("Back end: not allowed");
        List dtos = restTemplate.getForObject("https://temp-review-system.herokuapp.com/reviews/not-allowed", List.class);

        if(dtos.size() != 0){
            return ResponseEntity.ok(dtos);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<ReviewDTO>> getAll() {
        System.out.println("Back end: get all");
        List dtos = restTemplate.getForObject("https://temp-review-system.herokuapp.com/reviews", List.class);

        if(dtos.size() != 0){
            return ResponseEntity.ok(dtos);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO review){
        System.out.println("Back end: create");
        ReviewDTO dto = restTemplate.postForObject("https://temp-review-system.herokuapp.com/reviews", review, ReviewDTO.class);

        if(dto != null){
            return ResponseEntity.ok().body(dto);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<ReviewDTO> editReview(@RequestBody ReviewDTO review, @PathVariable("reviewId") int reviewId) {
        System.out.println("Back end: update");
        restTemplate.put("https://temp-review-system.herokuapp.com/reviews/"+reviewId, review);

        return ResponseEntity.ok().body(review);
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.DELETE)
    public void deleteReview(@PathVariable("reviewId") int reviewId){
        System.out.println("Back end: delete");
        restTemplate.delete("https://temp-review-system.herokuapp.com/reviews/"+reviewId);
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ReviewDTO> getOneReview(@PathVariable("reviewId") int reviewId){
        System.out.println("Back end: get one");
        ReviewDTO dto = restTemplate.getForObject("https://temp-review-system.herokuapp.com/reviews/"+reviewId, ReviewDTO.class);

        if(dto != null){
            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "/accommodation/{accommodationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<ReviewDTO>> getAllReviewsForPlace(@PathVariable("accommodationId") int accommodationId){
        System.out.println("Back end: all for place");
        List dtos = restTemplate.getForObject("https://temp-review-system.herokuapp.com/reviews/accommodation/"+accommodationId, List.class);

        if(dtos.size() != 0){
            return ResponseEntity.ok(dtos);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @RequestMapping(value = "/accommodation/{accommodationId}/grade", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Float calculateReview(@PathVariable("accommodationId") int accommodationId){
        System.out.println("Back end: get grade");
        return  restTemplate.getForObject("https://temp-review-system.herokuapp.com/reviews/accommodation/"+accommodationId+"/grade", Float.class);
    }

    @RequestMapping(value = "/accommodation/{accommodationId}/grade/{gradeVal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<ReviewDTO>> getAllGradesWithValueForAccomodation(@PathVariable("accommodationId") Integer accId, @PathVariable("gradeVal") Integer gradeVal){
        List dtos = restTemplate.getForObject("https://temp-review-system.herokuapp.com/reviews/accommodation/"+accId+"/grade/"+gradeVal, List.class);

        if(dtos.size() != 0){
            return ResponseEntity.ok(dtos);
        }

        return ResponseEntity.badRequest().body(null);
    }

    public ReviewDTO allowReview(Review r){
        ReviewDTO dto = new ReviewDTO();
        dto.setComment(r.getComment());
        dto.setAccomodationId(r.getAccomodation().getAccommodationId());
        dto.setAllowed(r.isAllowed());
        dto.setGrade(r.getGrade());
        dto.setReviewId(r.getReviewId());
        dto.setUser(r.getUser().getUsername());

        return restTemplate.postForObject("https://temp-review-system.herokuapp.com/reviews/allow", dto, ReviewDTO.class);
    }

    public ReviewDTO declineReview(Review r){
        ReviewDTO dto = new ReviewDTO();
        dto.setComment(r.getComment());
        dto.setAccomodationId(r.getAccomodation().getAccommodationId());
        dto.setAllowed(r.isAllowed());
        dto.setGrade(r.getGrade());
        dto.setReviewId(r.getReviewId());
        dto.setUser(r.getUser().getUsername());

        return restTemplate.postForObject("https://temp-review-system.herokuapp.com/reviews/decline", dto, ReviewDTO.class);
    }
}
