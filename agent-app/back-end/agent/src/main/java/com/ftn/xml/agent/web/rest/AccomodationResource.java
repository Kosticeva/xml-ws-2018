package com.ftn.xml.agent.web.rest;

import com.ftn.xml.agent.domain.Accomodation;
import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.domain.Category;
import com.ftn.xml.agent.dto.AccomodationDTO;
import com.ftn.xml.agent.service.AccomodationService;
import com.ftn.xml.agent.service.AccomodationServiceService;
import com.ftn.xml.agent.service.AccomodationTypeService;
import com.ftn.xml.agent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/accomodation")
@CrossOrigin(origins = "http://localhost:4200/*")
public class AccomodationResource {

	@Autowired
	AccomodationService accomodationService;

	@Autowired
	AccomodationServiceService accomodationServiceService;

	@Autowired
	AccomodationTypeService accomodationTypeService;

	@Autowired
	CategoryService categoriesService;

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

	@GetMapping("/read")
	public ResponseEntity<List<Accomodation>> getAccomodations() {
		Agent a = (Agent) session.getAttribute("user");
		List<Accomodation> accomodations = accomodationService.findAll(a);
		return ResponseEntity.ok(accomodations);
	}

	@GetMapping("/services")
	public ResponseEntity<List<com.ftn.xml.agent.domain.AccomodationService>> getServices() {
		List<com.ftn.xml.agent.domain.AccomodationService> services = accomodationServiceService.getServices();
		return ResponseEntity.ok(services);
	}

	@GetMapping("/types")
	public ResponseEntity<List<com.ftn.xml.agent.domain.AccomodationType>> getTypes() {
		List<com.ftn.xml.agent.domain.AccomodationType> types = accomodationTypeService.getTypes();
		return ResponseEntity.ok(types);
	}

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = categoriesService.findAll();
		return ResponseEntity.ok(categories);
	}

}
