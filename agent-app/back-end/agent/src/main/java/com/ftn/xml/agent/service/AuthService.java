package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.dto.LoginDTO;
import com.ftn.xml.agent.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthService {

	@Autowired
	AgentRepository agentRepository;

	@Autowired
	private HttpSession httpSession;

	public Agent authenticateAgent(LoginDTO loginDTO) {
		Agent agent = agentRepository.findById(loginDTO.getUsername()).get();
		if(agent.getPassword().equals(loginDTO.getPassword())) {
			httpSession.setAttribute("activeAgent", agent);
		}
		return agent;
	}

}
