package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.domain.Reservation;
import com.ftn.xml.agent.dto.ReservationDTO;
import com.ftn.xml.agent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationResource {

	@Autowired
	ReservationService reservationService;

	@Autowired
	HttpSession session;

	@PostMapping("/create")
	public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO reservationDTO) {
		Reservation r = reservationService.createReservation(reservationDTO);
		return ResponseEntity.ok(r);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Reservation>> getReservations() {
		Agent a = (Agent) session.getAttribute("user");
		List<Reservation> reservations = reservationService.findAll(a);
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
