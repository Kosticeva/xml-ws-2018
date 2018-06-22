package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Reservation;
import com.ftn.xml.agent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationResource {

	@Autowired
	ReservationService reservationService;

	@GetMapping("/approve/{id}")
	public ResponseEntity<Reservation> approveReservation(@PathVariable int id) {
		Reservation r = reservationService.approveReservation(id);
		return ResponseEntity.ok(r);
	}

	@GetMapping("/reject/{id}")
	public ResponseEntity<Reservation> rejectReservation(@PathVariable int id) {
		Reservation r = reservationService.rejectReservation(id);
		return ResponseEntity.ok(r);
	}

}
