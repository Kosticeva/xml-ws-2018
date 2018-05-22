package com.xml.booking.repository;

import com.xml.booking.domain.AccomodationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationServiceRepository  extends JpaRepository<AccomodationService, Integer> {
}
