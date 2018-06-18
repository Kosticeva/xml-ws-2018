package com.xml.booking.web.rest;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.TLocation;
import com.xml.booking.service.SearchService;
import com.xml.booking.web.rest.util.SearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SearchResource {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public List<Accomodation> getAccomodationsSimpleSearch(SearchQuery query){

        if(query.getCity() == null){
            return null;
        }

        if(query.getDateOfArrival() == null || query.getDateOfReturn() == null){
            return null;
        }

        if(query.getPersons() == null || query.getPersons() < 1){
            return null;
        }

        return searchService.doSimpleSearch(query);
    }

    @RequestMapping(value = "/search/advanced", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public List<Accomodation> getAccomodationsAdvancedSearch(SearchQuery query){

        if(query.getCity() == null){
            return null;
        }

        if(query.getDateOfArrival() == null || query.getDateOfReturn() == null){
            return null;
        }

        if(query.getPersons() == null || query.getPersons() < 1){
            return null;
        }

        return searchService.doAdvancedSearch(query);
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<TLocation> getLocations(@RequestParam(value="query", required=true) String query){
        return searchService.getAllLocationsMatchingTheCriteria(query);
    }

}
