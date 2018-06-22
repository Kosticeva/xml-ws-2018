package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginResource {

	@Autowired
	SyncService syncService;

	@PostMapping("/login")
	public ResponseEntity<Agent> loginAgent() {
		Agent a = new Agent();
		a.setFirstName("test");
		syncService.initializeOnLogin();
		return ResponseEntity.ok(a);
	}

}
