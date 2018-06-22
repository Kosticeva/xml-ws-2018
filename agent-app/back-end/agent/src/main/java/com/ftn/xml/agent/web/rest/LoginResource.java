package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.dto.LoginDTO;
import com.ftn.xml.agent.service.AuthService;
import com.ftn.xml.agent.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginResource {

	@Autowired
	SyncService syncService;

	@Autowired
	AuthService authService;

	@Autowired
	HttpSession session;

	@PostMapping("/login")
	public ResponseEntity<Agent> loginAgent(@RequestBody LoginDTO loginDTO) {
		syncService.initializeOnLogin();
		Agent agent = authService.authenticateAgent(loginDTO);
		if(agent != null) {
			session.setAttribute("user", agent);
		}
		else {
			session.setAttribute("user", null);
		}
		return ResponseEntity.ok(agent);
	}

}
