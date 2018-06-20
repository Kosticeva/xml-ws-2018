package com.xml.booking.wsendpoint;

import com.xml.booking.domain.User;
import com.xml.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ws.UserRequest;
import ws.UserResponse;

@Endpoint
public class UserEndpoint {

	@Autowired
	UserRepository userRepository;

	@PayloadRoot(namespace = "ws", localPart = "UserRequest")
	@ResponsePayload
	public UserResponse getUser(@RequestPayload UserRequest request) {
		UserResponse response = new UserResponse();
		User user = userRepository.findById(request.getUsername()).get();
		response.setUser(user);
		System.out.println(user.toString());
		return response;
	}

}
