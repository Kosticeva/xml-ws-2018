package com.xml.booking.service;

import com.xml.booking.domain.Agent;
import com.xml.booking.domain.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    public Message sendMessage(Message message);
    public List<Message> getConversation(String userUsername, String agentUsername);
    public List<Agent> getAllAgentsForUserUsername(String userUsername);
}
