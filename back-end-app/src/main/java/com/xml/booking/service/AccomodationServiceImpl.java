package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    @Autowired
    AccomodationRepository accomodationRepository;

    @Override
    public Accomodation get(int id) {
        return accomodationRepository.findById(id).orElse(null);
    }
}
