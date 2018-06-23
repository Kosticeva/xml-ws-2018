package com.xml.booking.service;

import com.xml.booking.agent.rest.dto.AgentAccomodationDTO;
import com.xml.booking.domain.Accomodation;
import com.xml.booking.dto.AccomodationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccomodationService {

    Accomodation save(Accomodation ac);
	Accomodation saveDTO(AgentAccomodationDTO ac);
    Accomodation get(int id);
    List<Accomodation> findAll();
	void delete(int id);
}
