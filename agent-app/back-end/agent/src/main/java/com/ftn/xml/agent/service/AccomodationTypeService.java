package com.ftn.xml.agent.service;

import com.ftn.xml.agent.domain.AccomodationType;
import com.ftn.xml.agent.repository.AccomodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationTypeService {

	@Autowired
	AccomodationTypeRepository accomodationTypeRepository;

	public List<AccomodationType> getTypes() {
		return accomodationTypeRepository.findAll();
	}
}
