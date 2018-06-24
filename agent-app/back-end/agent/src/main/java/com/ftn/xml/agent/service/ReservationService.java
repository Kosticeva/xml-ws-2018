package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.Reservation;
import com.ftn.xml.agent.dto.ReservationDTO;
import com.ftn.xml.agent.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	RestTemplate restTemplate;

	public Reservation createReservation(ReservationDTO reservationDTO) {
		ResponseEntity<Reservation> res = restTemplate.postForEntity("http://localhost:8091/reservation/reserve",
				reservationDTO, Reservation.class);
		Reservation r = res.getBody();
		r = reservationRepository.save(r);
		return r;
	}

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation approveReservation(int id) {
		Reservation reservation = reservationRepository.findById(id).get();
		reservation.setRealized(true);

		ResponseEntity<Reservation> res = restTemplate.postForEntity("http://localhost:8091/reservation/update",
				reservation, Reservation.class);
		Reservation r = res.getBody();
		System.out.println(r);
		reservation = reservationRepository.save(r);
		return r;
	}

	public Reservation rejectReservation(int id) {
		Reservation reservation = reservationRepository.findById(id).get();
		reservation.setRealized(false);

		ResponseEntity<Reservation> res = restTemplate.postForEntity("http://localhost:8091/reservation/update",
				reservation, Reservation.class);
		Reservation r = res.getBody();
		System.out.println(r);
		reservation = reservationRepository.save(r);
		return r;
	}
}
