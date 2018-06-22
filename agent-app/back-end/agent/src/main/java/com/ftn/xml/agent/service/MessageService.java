package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.Message;
import com.ftn.xml.agent.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	RestTemplate restTemplate;

	public Message sendMessage(Message message) {
		ResponseEntity<Message> res = restTemplate.postForEntity("http://localhost:8091/message/create",
				message, Message.class);
		Message m = res.getBody();
		System.out.println(m);
		messageRepository.save(m);
		return m;
	}

	public List<Message> findAll() {
		return messageRepository.findAll();
	}
}
