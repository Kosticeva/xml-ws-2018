package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Accomodation;
import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.dto.AccomodationDTO;
import com.ftn.xml.agent.service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/accomodation")
@CrossOrigin(origins = "http://localhost:4200/*")
public class AccomodationResource {

	@Autowired
	AccomodationService accomodationService;

	@Autowired
	HttpSession session;

	@PostMapping("/create")
	public ResponseEntity<Accomodation> createAccomodation(@RequestBody AccomodationDTO accomodationDTO) {
		Agent a = (Agent) session.getAttribute("user");
		if(accomodationDTO.getAgentUsername() == null) {
			accomodationDTO.setAgentUsername(a.getUsername());
		}
		Accomodation acc = accomodationService.save(accomodationDTO);
		return ResponseEntity.ok(acc);
	}

}
