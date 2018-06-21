package com.xml.booking.wsendpoint;

import com.xml.booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ws.ReservationRequest;
import ws.ReservationResponse;

@Endpoint
public class ReservationEndpoint {

	@Autowired
	ReservationRepository reservationRepository;

	@PayloadRoot(namespace = "ws", localPart = "ReservationRequest")
	@ResponsePayload
	public ReservationResponse getReservation(@RequestPayload ReservationRequest request) {
		ReservationResponse response = new ReservationResponse();
		/*
		Reservation reservation = reservationRepository.findById(request.getReservationId()).get();
		response.setReservation(reservation);
		*/
		return response;
	}

}
