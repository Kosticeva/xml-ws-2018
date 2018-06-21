package com.xml.booking.wsendpoint;

import com.xml.booking.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ws.AgentRequest;
import ws.AgentResponse;

@Endpoint
public class AgentEndpoint {

	@Autowired
	AgentRepository agentRepository;

	@PayloadRoot(namespace = "ws", localPart = "AgentRequest")
	@ResponsePayload
	public AgentResponse getUser(@RequestPayload AgentRequest request) {
		AgentResponse response = new AgentResponse();
		/*
		Agent agent = agentRepository.findById(request.getUsername()).get();
		response.setAgent(agent);
		*/
		return response;
	}

}
