package com.xml.booking.service;

import com.xml.booking.domain.AccomodationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccomodationSerService {

    AccomodationService save(AccomodationService ac);
    boolean delete(String id);
    List<AccomodationService> getAll();
    AccomodationService get(int id);
}
