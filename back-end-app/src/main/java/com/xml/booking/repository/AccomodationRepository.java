package com.xml.booking.repository;

import com.xml.booking.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Integer> {

    public List<Accomodation> findByLocation(TLocation location);

    public List<Accomodation> findByLocationAndCategoryInAndAccomodationServicesInAndAccomodationTypeIn
            (TLocation location, List<Category> categories, List<AccomodationService> accomodationServices,
             List<AccomodationType> accomodationTypes);
}
