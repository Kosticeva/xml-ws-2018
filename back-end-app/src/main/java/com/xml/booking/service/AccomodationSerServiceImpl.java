package com.xml.booking.service;


import com.xml.booking.domain.AccomodationService;
import com.xml.booking.repository.AccomodationServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationSerServiceImpl implements AccomodationSerService {

    @Autowired
    private AccomodationServiceRepository accomodationServiceRepository;

    @Override
    public AccomodationService save(AccomodationService ac){
        return this.accomodationServiceRepository.save(ac);

    }

    @Override
    public boolean delete(String id) {
        if (this.accomodationServiceRepository.findById(Integer.parseInt(id)).isPresent()) {
            this.accomodationServiceRepository.delete(this.accomodationServiceRepository.findById(Integer.parseInt(id)).get());;
            return true;
        }
        return false;
    }

    @Override
    public List<AccomodationService> getAll() {
        return this.accomodationServiceRepository.findAll();
    }

}
