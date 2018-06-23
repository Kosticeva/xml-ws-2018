package com.xml.booking.web.rest;

import com.xml.booking.domain.Category;
import com.xml.booking.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category-service")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true" )
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category cat) {
        Category category = this.categoryService.save(cat);
        if (category != null) return new ResponseEntity<>(category, HttpStatus.CREATED);
        return new ResponseEntity<>(category, HttpStatus.BAD_REQUEST);
    }


    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = this.categoryService.delete(id);
        if (deleted) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category at) {
        Category category = this.categoryService.save(at);
        if (category != null) return new ResponseEntity<>(category, HttpStatus.OK);
        return new ResponseEntity<>(category, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(this.categoryService.getAll(), HttpStatus.OK);
    }


}
