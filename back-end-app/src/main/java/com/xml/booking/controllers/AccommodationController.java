package com.xml.booking.controllers;


import com.xml.booking.domain.Accomodation;
import com.xml.booking.dto.AccomodationDTO;
import com.xml.booking.service.AccomodationService;
import com.xml.booking.web.rest.ReviewResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    AccomodationService accomodationService;

    @Autowired
    ReviewResource reviewResource;

    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AccomodationDTO> get(@PathVariable("id") int accommodationId) {
        Accomodation accomodation = accomodationService.get(accommodationId);
        AccomodationDTO accomodationDTO = new AccomodationDTO();
        accomodationDTO.setName(accomodation.getName());
        accomodationDTO.setId(accomodation.getAccommodationId());
        accomodationDTO.setAddress(accomodation.getLocation().getAddress());
        accomodationDTO.setAgentUsername(accomodation.getAgent().getUsername());

        //average rating (jbg)
        float grade = reviewResource.calculateReview(accommodationId);
        accomodationDTO.setAverageGrade(grade);

        accomodationDTO.setCategoryName(accomodation.getCategory().getCategoryName());
        accomodationDTO.setCity(accomodation.getLocation().getCity());
        accomodationDTO.setCountry(accomodation.getLocation().getCountry());
        accomodationDTO.setDescription(accomodation.getDescription());
        accomodationDTO.setType(accomodation.getAccomodationType().getTypeName());

        List<String> services = new ArrayList<String>();
        for (com.xml.booking.domain.AccomodationService as : accomodation.getAccomodationServices()) {
            services.add(as.getServiceName());
        }
        accomodationDTO.setServices(services);

        return new ResponseEntity<AccomodationDTO>(accomodationDTO, HttpStatus.OK);
    }
}
