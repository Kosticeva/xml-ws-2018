package com.xml.booking.service;

import com.xml.booking.agent.rest.dto.AgentMessageDTO;
import com.xml.booking.domain.Agent;
import com.xml.booking.domain.Message;
import com.xml.booking.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

	Message sendMessage(Message message);
    List<Message> getConversation(String userUsername, String agentUsername);
    List<Agent> getAllAgentsForUserUsername(String userUsername);
	List<Message> findAll();
	Message get(int id);
	Message create(AgentMessageDTO messageDTO);
	void delete(int id);
	Message setSeen(int id);

}
