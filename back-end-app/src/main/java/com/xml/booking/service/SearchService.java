package com.xml.booking.service;

import com.xml.booking.domain.AccomodationService;
import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.TLocation;
import com.xml.booking.domain.AccomodationType;
import com.xml.booking.domain.Category;
import com.xml.booking.domain.Reservation;
import com.xml.booking.dto.AccomodationDTO;
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

    @Autowired
    PriceService priceService;

    @Autowired
    ReviewService reviewService;

    public List<AccomodationDTO> doSimpleSearch(SearchQuery searchQuery){
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

        return convertToDTOs(accomodations, searchQuery);
    }

    public List<AccomodationDTO> doAdvancedSearch(SearchQuery searchQuery){

        List<TLocation> locations = findAllLocations(searchQuery.getAddress(), searchQuery.getCity(), searchQuery.getCountry());
        List<AccomodationType> types = accomodationTypeRepository.findByTypeIDIn(searchQuery.getAccomodationTypes());
        List<AccomodationService> services = accomodationServiceRepository.findByServiceIDIn(searchQuery.getAccomodationServices());
        List<Category> categories = categoryRepository.findByCategoryIDIn(searchQuery.getAccomodationCategories());

        List<Accomodation> accomodations = new ArrayList<>();

        for(TLocation tl: locations){

            if(types.size() > 0 && categories.size() > 0 && services.size() > 0){
                accomodations.addAll(accomodationRepository.findByLocationAndAccomodationTypeInAndCategoryInAndAccomodationServicesIn(
                        tl, types, categories, services));
            }else if(types.size() > 0 && categories.size() > 0){
                accomodations.addAll(accomodationRepository.findByLocationAndAccomodationTypeInAndCategoryIn(tl, types, categories));
            }else if(types.size() > 0 && services.size() > 0){
                accomodations.addAll(accomodationRepository.findByLocationAndAccomodationTypeInAndAccomodationServicesIn(tl, types, services));
            }else if(services.size() > 0 && categories.size() > 0){
                accomodations.addAll(accomodationRepository.findByLocationAndCategoryInAndAccomodationServicesIn(tl, categories, services));
            }else if(types.size() > 0){
                accomodations.addAll(accomodationRepository.findByLocationAndAccomodationTypeIn(tl, types));
            }else if(categories.size() > 0){
                accomodations.addAll(accomodationRepository.findByLocationAndCategoryIn(tl, categories));
            }else if(services.size() > 0) {
                accomodations.addAll(accomodationRepository.findByLocationAndAccomodationServicesIn(tl, services));
            }
        }

        return convertToDTOs(accomodations, searchQuery);
    }

    private List<AccomodationDTO> convertToDTOs(List<Accomodation> accomodations, SearchQuery searchQuery){
        List<AccomodationDTO> accomDTOs = new ArrayList<>();
        for(Accomodation ac: accomodations){
            if(checkIfThereIsAPlaceAvailable(ac, searchQuery)){
                AccomodationDTO dto = new AccomodationDTO();

                dto.setAccomodationId(ac.getAccommodationId());
                dto.setAddress(ac.getLocation().getAddress());
                dto.setCity(ac.getLocation().getCity());
                dto.setCountry(ac.getLocation().getCountry());
                dto.setAgentUsername(ac.getAgent().getUsername());
                dto.setDescription(ac.getDescription());

                dto.setName(ac.getName());
                dto.setCategoryName(ac.getCategory().getCategoryName());
                dto.setType(ac.getAccomodationType().getTypeName());

                List<String> services = new ArrayList<>();
                for(AccomodationService as: ac.getAccomodationServices()){
                    services.add(as.getServiceName());
                }

                dto.setServices(services);

                dto.setAverageGrade(reviewService.calculateAverageGrade(dto.getAccomodationId()));
                dto.setPrice(priceService.calculateFullPrice(ac, searchQuery.getDateOfArrival(), searchQuery.getDateOfReturn(), searchQuery.getPersons()));

                accomDTOs.add(dto);
            }
        }

        return accomDTOs;
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

        locations.addAll(tLocationRepository.findByAddressStartingWith(query));
        locations.addAll(tLocationRepository.findByCityStartingWith(query));
        locations.addAll(tLocationRepository.findByCountryStartingWith(query));

        return locations;
    }

}
