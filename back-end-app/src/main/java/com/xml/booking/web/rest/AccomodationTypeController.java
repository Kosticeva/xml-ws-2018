package com.xml.booking.web.rest;


import com.xml.booking.domain.AccomodationType;
import com.xml.booking.service.AccomodationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accomodation-type")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AccomodationTypeController {


    @Autowired
    private AccomodationTypeService accomodationTypeService;

    @PostMapping
    public ResponseEntity<AccomodationType> save(@RequestBody AccomodationType at) {
        AccomodationType accomodationType = this.accomodationTypeService.save(at);
        if (accomodationType != null) return new ResponseEntity<>(accomodationType, HttpStatus.CREATED);
        return new ResponseEntity<>(accomodationType, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = this.accomodationTypeService.delete(id);
        if (deleted) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<AccomodationType> update(@RequestBody AccomodationType at) {
        AccomodationType accomodationType = this.accomodationTypeService.save(at);
        if (accomodationType != null) return new ResponseEntity<>(accomodationType, HttpStatus.OK);
        return new ResponseEntity<>(accomodationType, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<AccomodationType>> getAll() {
        return new ResponseEntity<>(this.accomodationTypeService.getAll(), HttpStatus.OK);
    }
}
