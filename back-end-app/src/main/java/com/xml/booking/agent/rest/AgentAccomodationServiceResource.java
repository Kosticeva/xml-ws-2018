package com.xml.booking.agent.rest;

import com.xml.booking.domain.AccomodationService;
import com.xml.booking.service.AccomodationSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accomodationService")
public class AgentAccomodationServiceResource {

	@Autowired
	AccomodationSerService accomodationSerService;

	@GetMapping("/read")
	public ResponseEntity<List<AccomodationService>> getAccomodations() {
		List<AccomodationService> accomodations = accomodationSerService.getAll();
		return ResponseEntity.ok(accomodations);
	}

}
