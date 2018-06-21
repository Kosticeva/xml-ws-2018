package com.xml.booking.agent.rest;

import com.xml.booking.domain.Message;
import com.xml.booking.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class AgentMessageResource {

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

	@GetMapping("/read/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable int id) {
		Message accomodation = messageService.get(id);
		return ResponseEntity.ok(accomodation);
	}

	@PostMapping("/update")
	public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
		Message m = messageService.sendMessage(message);
		return ResponseEntity.ok(m);
	}

	@PostMapping("/delete")
	public ResponseEntity<Message> deleteMessage(@PathVariable int id) {
		messageService.delete(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add(getClass().getName().toString(), "DELETED " + id);
		return ResponseEntity.ok().headers(headers).build();
	}

}
