package com.xml.booking.agent.rest;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accomodation")
public class AgentAccomodationResource {

	@Autowired
	AccomodationService accomodationService;

	@PostMapping("/create")
	public ResponseEntity<Accomodation> createAccomodation(@RequestBody Accomodation accomodation) {
		accomodation.setAccommodationId(0);
		Accomodation acc = accomodationService.save(accomodation);
		return ResponseEntity.ok(acc);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Accomodation>> getAccomodations() {
		List<Accomodation> accomodations = accomodationService.findAll();
		return ResponseEntity.ok(accomodations);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Accomodation> getAccomodation(@PathVariable int id) {
		Accomodation accomodation = accomodationService.get(id);
		return ResponseEntity.ok(accomodation);
	}

	@PostMapping("/update")
	public ResponseEntity<Accomodation> updateAccomodation(@RequestBody Accomodation accomodation) {
		Accomodation acc = accomodationService.save(accomodation);
		return ResponseEntity.ok(acc);
	}

	@PostMapping("/delete")
	public ResponseEntity<Accomodation> deleteAccomodation(@PathVariable int id) {
		accomodationService.delete(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add(getClass().getName().toString(), "DELETED " + id);
		return ResponseEntity.ok().headers(headers).build();
	}

}
