package com.xml.booking.repository;

import com.xml.booking.domain.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationTypeRepository  extends JpaRepository<AccomodationType, Integer> {
}
