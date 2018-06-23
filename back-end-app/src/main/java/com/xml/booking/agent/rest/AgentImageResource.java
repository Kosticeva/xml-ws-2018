package com.xml.booking.agent.rest;

import com.xml.booking.domain.Image;
import com.xml.booking.domain.TPrice;
import com.xml.booking.service.ImageService;
import com.xml.booking.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class AgentImageResource {

	@Autowired
	ImageService imageService;

	@GetMapping("/read")
	public ResponseEntity<List<Image>> getAccomodations() {
		List<Image> images = imageService.findAll();
		return ResponseEntity.ok(images);
	}

}
