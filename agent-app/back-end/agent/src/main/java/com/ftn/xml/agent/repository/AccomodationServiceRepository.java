package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.AccomodationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationServiceRepository  extends JpaRepository<AccomodationService, Integer> {

    public List<AccomodationService> findByServiceIDIn(List<Integer> serviceIDs);
}
