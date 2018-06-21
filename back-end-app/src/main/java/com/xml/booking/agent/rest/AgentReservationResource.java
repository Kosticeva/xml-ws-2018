package com.xml.booking.agent.rest;

import com.xml.booking.domain.Reservation;
import com.xml.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class AgentReservationResource {

	@Autowired
	ReservationService reservationService;

	@PostMapping("/create")
	public ResponseEntity<Reservation> creatReservation(@RequestBody Reservation reservation) {
		reservation.setReservationId(0);
		Reservation r = reservationService.save(reservation);
		return ResponseEntity.ok(r);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Reservation>> getReservations() {
		List<Reservation> reservations = reservationService.findAll();
		return ResponseEntity.ok(reservations);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable int id) {
		Reservation reservation = reservationService.get(id);
		return ResponseEntity.ok(reservation);
	}

	@PostMapping("/update")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
		Reservation r = reservationService.save(reservation);
		return ResponseEntity.ok(r);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable int id) {
		reservationService.delete(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add(getClass().getName().toString(), "DELETED " + id);
		return ResponseEntity.ok().headers(headers).build();
	}

	@PostMapping("/confirmReservation")
	public ResponseEntity<Reservation> updateReservation(@PathVariable int id) {
		Reservation r = reservationService.activateReservation(id);
		return ResponseEntity.ok(r);
	}

}

