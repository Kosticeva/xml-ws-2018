package com.ftn.xml.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ws.User;
import ws.UserRequest;
import ws.UserResponse;

@RestController
@RequestMapping("/api")
public class Test extends WebServiceGatewaySupport {

	@Autowired
	Jaxb2Marshaller marshaller;

	@GetMapping("/test/{username}")
	public User getUser(@PathVariable String username) {
		UserRequest request = new UserRequest();
		request.setUsername(username);
		setDefaultUri("http://localhost:8091/service/data");
		setMarshaller(marshaller);
		setUnmarshaller(marshaller);
		UserResponse response = (UserResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8091/service/data"));
		return response.getUser();
	}

}
