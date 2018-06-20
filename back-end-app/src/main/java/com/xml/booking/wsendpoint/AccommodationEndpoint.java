package com.xml.booking.wsendpoint;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ws.AccommodationRequest;
import ws.AccommodationResponse;
import ws.UserResponse;

@Endpoint
public class AccommodationEndpoint {

	@Autowired
	AccomodationRepository accomodationRepository;

	@PayloadRoot(namespace = "ws", localPart = "AccommodationRequest")
	@ResponsePayload
	public AccommodationResponse createAccommodation(@RequestPayload AccommodationRequest request) {
		AccommodationResponse response = new AccommodationResponse();
		Accomodation acc = accomodationRepository.findById(request.getId()).get();
		response.setAccommodation(acc);
		return response;
	}

}
