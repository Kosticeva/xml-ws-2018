package com.xml.booking.service;
import java.util.List;

import com.xml.booking.domain.AccomodationService;


public interface AccomodationSerService {

    AccomodationService save(AccomodationService ac);
    boolean delete(String id);
    List<AccomodationService> getAll();
}
