package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Message;
import com.ftn.xml.agent.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessagingResource {

	@Autowired
	MessageService messageService;

	@PostMapping("/create")
	public ResponseEntity<Message> createMessage(@RequestBody Message message) {
		message.setMessageId(0);
		Message m = messageService.sendMessage(message);
		return ResponseEntity.ok(m);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Message>> getMessages() {
		List<Message> messages = messageService.findAll();
		return ResponseEntity.ok(messages);
	}

}
