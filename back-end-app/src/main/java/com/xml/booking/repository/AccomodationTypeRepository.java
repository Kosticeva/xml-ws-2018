package com.xml.booking.repository;

import com.xml.booking.domain.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationTypeRepository  extends JpaRepository<AccomodationType, Integer> {

    public List<AccomodationType> findByTypeIDIn(List<Integer> typeIDs);

}
