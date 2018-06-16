package com.xml.booking.service;

import com.xml.booking.domain.AccomodationType;
import com.xml.booking.repository.AccomodationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationTypeServiceImpl implements AccomodationTypeService {

    @Autowired
    private AccomodationTypeRepository accomodationTypeRepository;


    @Override
    public AccomodationType save(AccomodationType at) {
        return this.accomodationTypeRepository.save(at);
    }

    @Override
    public boolean delete(String id) {
        if (this.accomodationTypeRepository.findById(Integer.parseInt(id)).isPresent()) {
            this.accomodationTypeRepository.delete(this.accomodationTypeRepository.findById(Integer.parseInt(id)).get());
            return true;
        }
        return false;
    }

    @Override
    public List<AccomodationType> getAll() {
        return this.accomodationTypeRepository.findAll();
    }
}
