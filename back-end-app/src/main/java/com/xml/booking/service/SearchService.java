package com.xml.booking.service;

import com.xml.booking.domain.AccomodationService;
import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.TLocation;
import com.xml.booking.domain.AccomodationType;
import com.xml.booking.domain.Category;
import com.xml.booking.domain.Reservation;
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
        for(int i=0; i<locations.size(); i++){
            System.out.println(locations.get(i));
        }

        List<Accomodation> accomodations = new ArrayList<>();

        for(TLocation tl: locations){
            accomodations.addAll(accomodationRepository.findByLocation(tl));
        }

        for(int i=0; i<locations.size(); i++){
            System.out.println(accomodations.get(i));
        }

        List<Accomodation> finalAccomodations = new ArrayList<>();
        for(Accomodation ac: accomodations){
            if(checkIfThereIsAPlaceAvailable(ac, searchQuery)){
                finalAccomodations.add(ac);
            }
        }

        for(int i=0; i<locations.size(); i++){
            System.out.println(finalAccomodations.get(i));
        }

        return finalAccomodations;
    }

    public List<Accomodation> doAdvancedSearch(SearchQuery searchQuery){

        List<TLocation> locations = findAllLocations(searchQuery.getAddress(), searchQuery.getCity(), searchQuery.getCountry());
        List<AccomodationType> types = accomodationTypeRepository.findByTypeIDIn(searchQuery.getAccomodationTypes());
        List<AccomodationService> services = accomodationServiceRepository.findByServiceIDIn(searchQuery.getAccomodationServices());
        List<Category> categories = categoryRepository.findByCategoryIDIn(searchQuery.getAccomodationCategories());

        for(int i=0; i<locations.size(); i++){
            System.out.println(locations.get(i));
        }
        for(int i=0; i<types.size(); i++){
            System.out.println(types.get(i));
        }
        for(int i=0; i<categories.size(); i++){
            System.out.println(categories.get(i));
        }

        for(int i=0; i<services.size(); i++){
            System.out.println(services.get(i));
        }


        List<Accomodation> accomodations = new ArrayList<>();

        for(TLocation tl: locations){
            accomodations.addAll(
                    accomodationRepository.findByLocationAndCategoryInAndAccomodationServicesInAndAccomodationTypeIn(
                            tl, categories, services, types));
        }

        for(int i=0; i<locations.size(); i++){
            System.out.println(accomodations.get(i));
        }

        List<Accomodation> finalAccomodations = new ArrayList<>();
        for(Accomodation ac: accomodations){
            if(checkIfThereIsAPlaceAvailable(ac, searchQuery)){
                finalAccomodations.add(ac);
            }
        }

        for(int i=0; i<locations.size(); i++){
            System.out.println(finalAccomodations.get(i));
        }

        return finalAccomodations;
    }

    private List<TLocation> findAllLocations(String address, String city, String country){

        List<TLocation> locations = new ArrayList<>();
        if(address != null && city != null && country != null){
            System.out.println("SVA TRI");
            locations = tLocationRepository.findByAddressAndCityAndCountry(address, city, country);
        } else if(address != null && city != null){
            System.out.println("SAMO GRAD I ADRESA");
            locations = tLocationRepository.findByAddressAndCity(address, city);
        } else if(city != null && country != null){
            System.out.println("grad i drzava");
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

        System.out.println("BR OSOBA ZA DATUM JE "+sum);
        if(sum + searchQuery.getPersons() < ac.getMaxPersons()){
            System.out.println("IMA MESTA");
            return true;
        }

        System.out.println("NEMA MESTA");
        return false;
    }

    public List<TLocation> getAllLocationsMatchingTheCriteria(String query){

        List<TLocation> locations = new ArrayList<>();

        locations.addAll(tLocationRepository.findByAddressStartingWith(query));
        locations.addAll(tLocationRepository.findByCityStartingWith(query));
        locations.addAll(tLocationRepository.findByCountryStartingWith(query));

        return locations;
    }

}
