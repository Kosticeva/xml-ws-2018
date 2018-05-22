package com.xml.booking.web.rest.util;

import com.xml.booking.domain.AccomodationService;
import com.xml.booking.domain.AccomodationType;
import com.xml.booking.domain.Category;
import com.xml.booking.domain.TLocation;

import java.sql.Date;
import java.util.List;

public class SearchQuery {

    //kako je reprezentovano na klijentu
    //ako ima 2 zareza, pune se sva 3
    //ako ima 1 zarez i broj u sebi, adresa i grad
    //ako ima 1 zarez i nema broj, grad i drzava
    //ako nema zarez i ima broj, adresa
    //ako nema zarez i nema broj, grad

    public String address;
    public String city;
    public String country;
    public Date dateOfArrival;
    public Date dateOfReturn;
    public Integer persons;

    public List<Integer> accomodationTypes;
    public List<Integer> accomodationCategories;
    public List<Integer> accomodationServices;

    public SearchQuery() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    public List<Integer> getAccomodationTypes() {
        return accomodationTypes;
    }

    public void setAccomodationTypes(List<Integer> accomodationTypes) {
        this.accomodationTypes = accomodationTypes;
    }

    public List<Integer> getAccomodationCategories() {
        return accomodationCategories;
    }

    public void setAccomodationCategories(List<Integer> accomodationCategories) {
        this.accomodationCategories = accomodationCategories;
    }

    public List<Integer> getAccomodationServices() {
        return accomodationServices;
    }

    public void setAccomodationServices(List<Integer> accomodationServices) {
        this.accomodationServices = accomodationServices;
    }
}
