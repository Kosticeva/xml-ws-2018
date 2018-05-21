package com.xml.booking.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello",
            method = RequestMethod.GET)
    public ResponseEntity<String> showHomePage() {
        return new ResponseEntity<String>("cao iz test kontrolera", HttpStatus.OK);
    }

}
