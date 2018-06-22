package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Accomodation;
import com.ftn.xml.agent.service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accomodation")
public class AccomodationResource {

	@Autowired
	AccomodationService accomodationService;

	@PostMapping("/create")
	public ResponseEntity<Accomodation> createAccomodation(@RequestBody Accomodation accomodation) {
		accomodation.setAccommodationId(0);
		Accomodation acc = accomodationService.save(accomodation);
		return ResponseEntity.ok(acc);
	}

}
