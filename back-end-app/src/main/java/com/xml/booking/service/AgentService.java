package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Agent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgentService {
    public Agent get(String username);

	List<Agent> findAll();

	Agent save(Agent agent);

	void delete(String id);
}
