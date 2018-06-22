package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Reservation;
import com.ftn.xml.agent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationResource {

	@Autowired
	ReservationService reservationService;

	@PostMapping("/create")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		Reservation r = reservationService.createReservation(reservation);
		return ResponseEntity.ok(r);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Reservation>> getReservations() {
		List<Reservation> reservations = reservationService.findAll();
		return ResponseEntity.ok(reservations);
	}

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
