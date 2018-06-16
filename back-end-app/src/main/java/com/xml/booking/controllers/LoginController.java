package com.xml.booking.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/logout")
    public void logout() {
        //logout?
    }

/*    @RequestMapping(value = "/user",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> user(Principal user) {
        return new ResponseEntity<String>("okej",HttpStatus.OK);
    }*/

}
