package com.xml.booking.service;
import java.util.List;

import com.xml.booking.domain.AccomodationService;
import org.springframework.stereotype.Service;

@Service
public interface AccomodationSerService {

    AccomodationService save(AccomodationService ac);
    boolean delete(String id);
    List<AccomodationService> getAll();
    AccomodationService get(int id);
}
