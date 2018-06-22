package com.xml.booking.agent.rest;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Agent;
import com.xml.booking.service.AccomodationService;
import com.xml.booking.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentAccountResource {

	@Autowired
	AgentService agentService;

	@PostMapping("/create")
	public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
		Agent acc = agentService.save(agent);
		return ResponseEntity.ok(acc);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Agent>> getAgents() {
		List<Agent> agents = agentService.findAll();
		return ResponseEntity.ok(agents);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Agent> getAccomodation(@PathVariable String id) {
		Agent agent = agentService.get(id);
		return ResponseEntity.ok(agent);
	}

	@PostMapping("/update")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) {
		Agent a = agentService.save(agent);
		return ResponseEntity.ok(a);
	}

	@PostMapping("/delete")
	public ResponseEntity<Accomodation> deleteAgent(@PathVariable String id) {
		agentService.delete(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add(getClass().getName().toString(), "DELETED " + id);
		return ResponseEntity.ok().headers(headers).build();
	}
}
