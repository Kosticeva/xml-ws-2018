package com.xml.booking.web.rest.administration;


import com.xml.booking.domain.Agent;
import com.xml.booking.domain.Review;
import com.xml.booking.domain.User;
import com.xml.booking.dto.ReviewDTO;
import com.xml.booking.service.AccomodationService;
import com.xml.booking.service.AdminService;
import com.xml.booking.service.UserService;
import com.xml.booking.web.rest.ReviewResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AdminController {


    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private AdminService adminService;

    private UserService userService;

    private AccomodationService accomodationService;

    private ReviewResource reviewResource;

    public AdminController(AdminService adminService, ReviewResource reviewResource, AccomodationService accomodationService, UserService userService) {
        this.adminService = adminService;
        this.reviewResource = reviewResource;
        this.userService = userService;
        this.accomodationService = accomodationService;
    }

    @PostMapping("/create-agent")
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        logger.debug("Create agent endpoint!");
        Agent a = this.adminService.createAgent(agent);
        if (a != null) return new ResponseEntity<>(a, HttpStatus.CREATED);
        return new ResponseEntity<>(a, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/activate-user")
    public ResponseEntity<User> activateUser(@RequestBody User user) {
        logger.debug("Activate user endpoint.");
        System.out.println("ACTIVATED" + user.getUsername());
        User u = this.adminService.activateUser(user, "ACTIVATED");
        if (u != null) return new ResponseEntity<>(u, HttpStatus.OK);
        return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/block-user")
    public ResponseEntity<User> blockUser(@RequestBody User user) {
        logger.debug("Block user endpoint.");
        User u = this.adminService.activateUser(user, "BLOCKED");
        if (u != null) return new ResponseEntity<>(u, HttpStatus.OK);
        return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/delete-user")
    public ResponseEntity deleteUser(@RequestBody User user) {
        logger.debug("Delete user endpoint.");
        boolean deleted = this.adminService.deleteUser(user);
        if (deleted) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/allow-review")
    public ResponseEntity<Review> allowReview(@RequestBody Review review) {
        logger.debug("Allow reivew endpoint!");
        ReviewDTO r = this.reviewResource.allowReview(review);

        if (r != null) {
            Review rr = new Review();
            rr.setReviewId(r.getReviewId());
            rr.setGrade(r.getGrade());
            rr.setAllowed(r.isAllowed());
            rr.setComment(r.getComment());
            rr.setUser(userService.findUser(r.getUser()));
            rr.setAccomodation(accomodationService.get(r.getAccomodationId()));
            return new ResponseEntity<>(rr, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Review(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/decline-review")
    public ResponseEntity<Review> declineReview(@RequestBody Review review) {
        logger.debug("Allow reivew endpoint!");
        ReviewDTO r = this.reviewResource.declineReview(review);

        if (r != null) {
            Review rr = new Review();
            rr.setReviewId(r.getReviewId());
            rr.setGrade(r.getGrade());
            rr.setAllowed(r.isAllowed());
            rr.setComment(r.getComment());
            rr.setUser(userService.findUser(r.getUser()));
            rr.setAccomodation(accomodationService.get(r.getAccomodationId()));
            return new ResponseEntity<>(rr, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Review(), HttpStatus.BAD_REQUEST);
    }
}
