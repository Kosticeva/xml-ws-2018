package com.xml.booking.agent.rest;

import com.xml.booking.domain.AccomodationType;
import com.xml.booking.service.AccomodationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accomodationType")
public class AgentAccomodationTypeResource {

	@Autowired
	AccomodationTypeService accomodationTypeService;

	@GetMapping("/read")
	public ResponseEntity<List<AccomodationType>> getAccomodationTypes() {
		List<AccomodationType> accomodationTypes = accomodationTypeService.findAll();
		return ResponseEntity.ok(accomodationTypes);
	}

}
