package com.xml.booking.repository;

import com.xml.booking.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Integer> {

    public List<Accomodation> findByLocation(TLocation location);

    public List<Accomodation> findDistinctByLocationAndAccomodationTypeInAndCategoryInAndAccomodationServicesIn(TLocation location, List<AccomodationType> accomodationTypes, List<Category> categories, List<AccomodationService> accomodationServices);

    public List<Accomodation> findDistinctByLocationAndAccomodationTypeInAndCategoryIn(TLocation location, List<AccomodationType> accomodationTypes, List<Category> categories);
    public List<Accomodation> findDistinctByLocationAndAccomodationTypeInAndAccomodationServicesIn(TLocation location, List<AccomodationType> accomodationTypes, List<AccomodationService> accomodationServices);
    public List<Accomodation> findDistinctByLocationAndCategoryInAndAccomodationServicesIn(TLocation location, List<Category> categories, List<AccomodationService> accomodationServices);

    public List<Accomodation> findDistinctByLocationAndCategoryIn(TLocation location, List<Category> categories);
    public List<Accomodation> findDistinctByLocationAndAccomodationTypeIn(TLocation location, List<AccomodationType> accomodationTypes);
    public List<Accomodation> findDistinctByLocationAndAccomodationServicesIn(TLocation location, List<AccomodationService> accomodationServices);
}
