package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccomodationService {

    Accomodation save(Accomodation ac);
    Accomodation get(int id);
    List<Accomodation> findAll();
	void delete(int id);
}
