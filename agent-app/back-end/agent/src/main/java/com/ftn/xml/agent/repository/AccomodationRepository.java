package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Integer> {

    List<Accomodation> findByLocation(TLocation location);

    List<Accomodation> findByLocationAndAccomodationTypeInAndCategoryInAndAccomodationServicesIn(TLocation location, List<AccomodationType> accomodationTypes, List<Category> categories, List<AccomodationService> accomodationServices);

    List<Accomodation> findByLocationAndAccomodationTypeInAndCategoryIn(TLocation location, List<AccomodationType> accomodationTypes, List<Category> categories);
    List<Accomodation> findByLocationAndAccomodationTypeInAndAccomodationServicesIn(TLocation location, List<AccomodationType> accomodationTypes, List<AccomodationService> accomodationServices);
    List<Accomodation> findByLocationAndCategoryInAndAccomodationServicesIn(TLocation location, List<Category> categories, List<AccomodationService> accomodationServices);

    List<Accomodation> findByLocationAndCategoryIn(TLocation location, List<Category> categories);
    List<Accomodation> findByLocationAndAccomodationTypeIn(TLocation location, List<AccomodationType> accomodationTypes);
    List<Accomodation> findByLocationAndAccomodationServicesIn(TLocation location, List<AccomodationService> accomodationServices);

    List<Accomodation> findByAgent(Agent agent);
}
