package com.xml.booking.service;

import com.xml.booking.domain.*;
import com.xml.booking.repository.*;
import com.xml.booking.web.rest.util.SearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    TLocationRepository tLocationRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    AccomodationTypeRepository accomodationTypeRepository;

    @Autowired
    AccomodationServiceRepository accomodationServiceRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Accomodation> doSimpleSearch(SearchQuery searchQuery){
        //how to calculate vacancies
        //find accomodations on wanted location
        //find all reservations that are lasting on that date
        //(arrivalDate <= currDate, departureDate >= currDate)
        //count the people in lasting reservations
        //sort by grade?

        List<TLocation> locations = findAllLocations(searchQuery.getAddress(), searchQuery.getCity(), searchQuery.getCountry());
        List<Accomodation> accomodations = new ArrayList<>();

        for(TLocation tl: locations){
            accomodations.addAll(accomodationRepository.findByLocation(tl));
        }

        List<Accomodation> finalAccomodations = new ArrayList<>();
        for(Accomodation ac: accomodations){
            if(checkIfThereIsAPlaceAvailable(ac, searchQuery)){
                finalAccomodations.add(ac);
            }
        }

        return finalAccomodations;
    }

    public List<Accomodation> doAdvancedSearch(SearchQuery searchQuery){

        List<TLocation> locations = findAllLocations(searchQuery.getAddress(), searchQuery.getCity(), searchQuery.getCountry());
        List<AccomodationType> types = accomodationTypeRepository.findByTypeIDIn(searchQuery.getAccomodationTypes());
        List<AccomodationService> services = accomodationServiceRepository.findByServiceIDIn(searchQuery.getAccomodationServices());
        List<Category> categories = categoryRepository.findByCategoryIDIn(searchQuery.getAccomodationCategories());

        List<Accomodation> accomodations = new ArrayList<>();

        for(TLocation tl: locations){
            accomodations.addAll(
                    accomodationRepository.findByLocationAndCategoryInAndAccomodationServiceInAndAccomodationTypeIn(
                            tl, categories, services, types));
        }

        List<Accomodation> finalAccomodations = new ArrayList<>();
        for(Accomodation ac: accomodations){
            if(checkIfThereIsAPlaceAvailable(ac, searchQuery)){
                finalAccomodations.add(ac);
            }
        }

        return finalAccomodations;
    }

    private List<TLocation> findAllLocations(String address, String city, String country){

        List<TLocation> locations = new ArrayList<>();
        if(address != null && city != null && country != null){
            locations = tLocationRepository.findByAddressAndCityAndCountry(address, city, country);
        } else if(address != null && city != null){
            locations = tLocationRepository.findByAddressAndCity(address, city);
        } else if(city != null && country != null){
            locations = tLocationRepository.findByCityAndCountry(city, country);
        }

        return locations;
    }

    private boolean checkIfThereIsAPlaceAvailable(Accomodation ac, SearchQuery searchQuery){
        List<Reservation> reservations = reservationRepository.findByAccomodationAndStartDateBeforeAndEndDateAfter(ac, searchQuery.getDateOfArrival(), searchQuery.getDateOfReturn());

        int sum = 0;
        for(Reservation res: reservations){
            sum += res.getNumPersons();
        }

        if(sum + searchQuery.getPersons() < ac.getMaxPersons()){
            return true;
        }

        return false;
    }

    public List<TLocation> getAllLocationsMatchingTheCriteria(String query){

        List<TLocation> locations = new ArrayList<>();

        locations.addAll(tLocationRepository.findByAddressLike(query));
        locations.addAll(tLocationRepository.findByCityLike(query));
        locations.addAll(tLocationRepository.findByCountryLike(query));

        return locations;
    }

}
