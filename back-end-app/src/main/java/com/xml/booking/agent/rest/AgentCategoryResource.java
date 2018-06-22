package com.xml.booking.agent.rest;

import com.xml.booking.domain.Category;
import com.xml.booking.domain.TPrice;
import com.xml.booking.service.CategoryService;
import com.xml.booking.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class AgentCategoryResource {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/read")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = categoryService.findAll();
		return ResponseEntity.ok(categories);
	}

}
