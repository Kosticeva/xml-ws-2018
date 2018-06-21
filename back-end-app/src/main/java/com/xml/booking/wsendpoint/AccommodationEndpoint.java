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
import ws.CreateAccommodationRequest;
import ws.CreateAccommodationResponse;

@Endpoint
public class AccommodationEndpoint {

	@Autowired
	AccomodationRepository accomodationRepository;

	@PayloadRoot(namespace = "ws", localPart = "AccommodationRequest")
	@ResponsePayload
	public CreateAccommodationResponse createAccommodation(@RequestPayload CreateAccommodationRequest request) {
		/*
		Accomodation accomodation = new Accomodation();
		Accomodation acc = request.getAccommodation();

		accomodation.setName(acc.getName());
		accomodation.setAccommodationId(acc.getAccommodationId());
		accomodation.setAccomodationService();*/

		CreateAccommodationResponse response = new CreateAccommodationResponse();



		return response;
	}

}
