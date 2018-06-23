package com.xml.booking.web.rest;

import com.xml.booking.domain.Category;
import com.xml.booking.service.AccomodationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accomodation-category")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AccomodationCategoryResource {


    @Autowired
    private AccomodationCategoryService accomodationCategoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Category> save(@RequestBody Category at) {
        Category accomodationType = this.accomodationCategoryService.save(at);
        if (accomodationType != null) return new ResponseEntity<>(accomodationType, HttpStatus.CREATED);
        return new ResponseEntity<>(accomodationType, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = this.accomodationCategoryService.delete(id);
        if (deleted) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Category> update(@RequestBody Category c) {
        Category accomodationType = this.accomodationCategoryService.save(c);
        if (accomodationType != null) return new ResponseEntity<>(accomodationType, HttpStatus.OK);
        return new ResponseEntity<>(accomodationType, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(this.accomodationCategoryService.getAll(), HttpStatus.OK);
    }
}
