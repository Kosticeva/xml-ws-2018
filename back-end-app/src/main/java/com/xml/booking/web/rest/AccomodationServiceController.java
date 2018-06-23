package com.xml.booking.web.rest;


import com.xml.booking.domain.AccomodationService;
import com.xml.booking.service.AccomodationSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accomodation-service")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true" )
public class AccomodationServiceController {

    @Autowired
    private AccomodationSerService accomodationSerService;

    @PostMapping
    public ResponseEntity<AccomodationService> save(@RequestBody AccomodationService as) {

        AccomodationService accomodationService = this.accomodationSerService.save(as);
        if (accomodationService != null) return new ResponseEntity<>(accomodationService, HttpStatus.CREATED);
        return new ResponseEntity<>(accomodationService, HttpStatus.BAD_REQUEST);

    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = this.accomodationSerService.delete(id);
        if (deleted) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @PutMapping
    public ResponseEntity<AccomodationService> update(@RequestBody AccomodationService as) {
        AccomodationService accomodationService = this.accomodationSerService.save(as);
        if (accomodationService != null) return new ResponseEntity<>(accomodationService, HttpStatus.OK);
        return new ResponseEntity<>(accomodationService, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<AccomodationService>> getAll() {
        return new ResponseEntity<>(this.accomodationSerService.getAll(), HttpStatus.OK);
    }


}