package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.AccomodationService;
import com.ftn.xml.agent.repository.AccomodationServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationServiceService {

	@Autowired
	AccomodationServiceRepository accomodationServiceRepository;

	public List<AccomodationService> getServices() {
		return accomodationServiceRepository.findAll();
	}
}
