package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    @Autowired
    AccomodationRepository accomodationRepository;

    @Override
    public Accomodation save(Accomodation ac) {
        return this.accomodationRepository.save(ac);
    }

    @Override
    public Accomodation get(int id) {
        return accomodationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Accomodation> findAll() {
        return accomodationRepository.findAll();
    }

    @Override
    public void delete(int id) {
        accomodationRepository.deleteById(id);
    }
}
