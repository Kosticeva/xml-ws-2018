package com.xml.booking.service;

import com.xml.booking.domain.Agent;
import com.xml.booking.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent get(String username) {
        return agentRepository.findById(username).orElse(null);
    }
}
