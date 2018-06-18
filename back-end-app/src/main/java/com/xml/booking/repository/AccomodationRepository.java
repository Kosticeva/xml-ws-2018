package com.xml.booking.repository;

import com.xml.booking.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Integer> {

    public List<Accomodation> findByLocation(TLocation location);

    public List<Accomodation> findByLocationAndAccomodationTypeInAndCategoryInAndAccomodationServicesIn(TLocation location, List<AccomodationType> accomodationTypes, List<Category> categories, List<AccomodationService> accomodationServices);

    public List<Accomodation> findByLocationAndAccomodationTypeInAndCategoryIn(TLocation location, List<AccomodationType> accomodationTypes, List<Category> categories);
    public List<Accomodation> findByLocationAndAccomodationTypeInAndAccomodationServicesIn(TLocation location, List<AccomodationType> accomodationTypes, List<AccomodationService> accomodationServices);
    public List<Accomodation> findByLocationAndCategoryInAndAccomodationServicesIn(TLocation location, List<Category> categories, List<AccomodationService> accomodationServices);

    public List<Accomodation> findByLocationAndCategoryIn(TLocation location, List<Category> categories);
    public List<Accomodation> findByLocationAndAccomodationTypeIn(TLocation location, List<AccomodationType> accomodationTypes);
    public List<Accomodation> findByLocationAndAccomodationServicesIn(TLocation location, List<AccomodationService> accomodationServices);
}
