package com.xml.booking.service;

import com.xml.booking.domain.AccomodationType;

import java.util.List;

public interface AccomodationTypeService {

    AccomodationType save(AccomodationType at);
    boolean delete(String id);
    List<AccomodationType> getAll();
    List<AccomodationType> findAll();
}
