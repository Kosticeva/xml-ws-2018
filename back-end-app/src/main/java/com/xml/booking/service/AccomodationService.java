package com.xml.booking.service;

import com.xml.booking.domain.Accomodation;
import org.springframework.stereotype.Service;

@Service
public interface AccomodationService {
    public Accomodation get(int id);
}
