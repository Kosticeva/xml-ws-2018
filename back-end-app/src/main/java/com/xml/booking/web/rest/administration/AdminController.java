package com.xml.booking.web.rest.administration;

import com.xml.booking.dto.ReviewDTO;
import com.xml.booking.web.rest.ReviewResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.booking.domain.Agent;
import com.xml.booking.domain.User;
import com.xml.booking.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private AdminService adminService;
    private ReviewResource reviewResource;

    public AdminController(AdminService adminService, ReviewResource reviewResource) {
        this.adminService = adminService;
        this.reviewResource = reviewResource;
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
    public ResponseEntity<ReviewDTO> allowReview(@RequestBody ReviewDTO review) {
        logger.debug("Allow reivew endpoint!");
        ReviewDTO ret = reviewResource.allowReview(review);

        if(ret == null){
            return ResponseEntity.unprocessableEntity().body(null);
        }

        return ResponseEntity.ok().body(ret);
    }

    @PutMapping("/decline-review")
    public ResponseEntity<ReviewDTO> declineReview(@RequestBody ReviewDTO review) {
        logger.debug("Allow reivew endpoint!");
        ReviewDTO ret = reviewResource.declineReview(review);
        if(ret == null){
            return ResponseEntity.unprocessableEntity().body(null);
        }

        return ResponseEntity.ok().body(ret);
    }
}
