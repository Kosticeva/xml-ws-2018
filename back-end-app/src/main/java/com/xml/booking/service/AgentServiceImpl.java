package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Agent;
import com.xml.booking.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent get(String username) {
        return agentRepository.findById(username).orElse(null);
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public void delete(String id) {
        agentRepository.deleteById(id);
    }
}
