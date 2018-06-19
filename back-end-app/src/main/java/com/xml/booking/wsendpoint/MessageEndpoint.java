package com.xml.booking.wsendpoint;

import com.xml.booking.domain.Message;
import com.xml.booking.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ws.MessageRequest;
import ws.MessageResponse;

@Endpoint
public class MessageEndpoint {

	@Autowired
	MessageRepository messageRepository;

	@PayloadRoot(namespace = "ws", localPart = "MessageRequest")
	@ResponsePayload
	public MessageResponse getMessage(@RequestPayload MessageRequest request) {
		MessageResponse response = new MessageResponse();
		System.out.println("ID: " + request.getMessageId());
		Message message = messageRepository.findById(request.getMessageId()).get();
		System.out.println(message.toString());
		System.out.println(message.getUser().getUsername());
		response.setMessage(message);
		return response;
	}

}
