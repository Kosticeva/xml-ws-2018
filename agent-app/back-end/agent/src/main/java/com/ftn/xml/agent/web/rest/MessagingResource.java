package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.domain.Message;
import com.ftn.xml.agent.dto.MessageDTO;
import com.ftn.xml.agent.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class MessagingResource {

	@Autowired
	MessageService messageService;

	@Autowired
	HttpSession httpSession;

	@PostMapping("/create")
	public ResponseEntity<Message> createMessage(@RequestBody MessageDTO messageDTO) {
		Agent a = (Agent) httpSession.getAttribute("user");
		messageDTO.setSender(a.getUsername());
		Message m = messageService.sendMessage(messageDTO);
		return ResponseEntity.ok(m);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable int id) {
		Agent a = (Agent) httpSession.getAttribute("user");
		Message message = messageService.findById(id);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Message>> getMessages() {
		Agent a = (Agent) httpSession.getAttribute("user");
		List<Message> messages = messageService.findByAgent(a);
		return ResponseEntity.ok(messages);
	}

	@GetMapping("/seen/{id}")
	public ResponseEntity<Message> setSeen(@PathVariable int id) {
		Message message = messageService.setSeen(id);
		return ResponseEntity.ok(message);
	}



}
