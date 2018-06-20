package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.SOAPConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.UserRequest;
import ws.UserResponse;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	SOAPConnector soapConnector;

	@GetMapping("/user/{username}")
	public UserResponse test(@PathVariable String username) {
		UserRequest request = new UserRequest();
		request.setUsername(username);
		Object response = soapConnector.callWebService("http://localhost:8091/service/data", request);
		System.out.println(response.toString());
		return (UserResponse) response;
	}

}
