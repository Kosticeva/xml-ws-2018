package com.xml.booking.web.rest.user;

import com.xml.booking.domain.User;
import com.xml.booking.dto.UserDTO;
import com.xml.booking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }



    @PostMapping("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO, HttpServletRequest httpRequest) {
        logger.debug("Login endpoint!");
        User us = this.userService.findUser(userDTO.getUsername());

        // check if user is activated
        if (us != null) {
            if (us.getPassword().equals(userDTO.getPassword())) {
                httpRequest.getSession().setAttribute("user", us);
                return new ResponseEntity<>(us, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<List<User>> getUsers() {
        logger.debug("Pending users endpoint!");
        return new ResponseEntity<>(this.userService.getUsers("PENDING"), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON
    )
    public ResponseEntity<UserDTO> getUser(Principal user) {
        User user1 = userService.getUser(user.getName());
        user1.setPassword("");
        return new ResponseEntity<UserDTO>(new UserDTO(user1), HttpStatus.OK);
    }

}
