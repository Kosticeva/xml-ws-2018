package com.xml.booking.web.rest.util;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class SearchQuery implements Serializable{

    //kako je reprezentovano na klijentu
    //ako ima 2 zareza, pune se sva 3
    //ako ima 1 zarez i broj u sebi, adresa i grad
    //ako ima 1 zarez i nema broj, grad i drzava
    //ako nema zarez i ima broj, adresa
    //ako nema zarez i nema broj, grad

    private String address;
    private String country;
    private String city;
    private Date dateOfArrival;
    private Date dateOfReturn;
    private Integer persons;

    private List<Integer> accomodationTypes;
    private List<Integer> accomodationCategories;
    private List<Integer> accomodationServices;

    public SearchQuery() {}

    public SearchQuery(String address, String country, String city, Date dateOfArrival, Date dateOfReturn,
                       Integer persons, List<Integer> accomodationTypes, List<Integer> accomodationCategories,
                       List<Integer> accomodationServices) {
        this.address = address;
        this.country = country;
        this.city = city;
        this.dateOfArrival = dateOfArrival;
        this.dateOfReturn = dateOfReturn;
        this.persons = persons;
        this.accomodationTypes = accomodationTypes;
        this.accomodationCategories = accomodationCategories;
        this.accomodationServices = accomodationServices;
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

    @Override
    public String toString(){
        String retVal = "\n-------------------------------------------------\n";
        retVal += "SEARCH\n";

        retVal += this.address+", "+this.city+", "+this.country;
        retVal += "\n\tFROM "+this.dateOfArrival+" TO "+this.dateOfReturn;
        retVal += "\n\tFOR "+this.persons;
        retVal += "\n\nADVANCED\n";
        retVal += "\tCATEGORIES: \n\t";

        if(accomodationCategories != null){
            for(int i=0; i<accomodationCategories.size(); i++){
                retVal += accomodationCategories.get(i)+", ";
            }
        }

        retVal += "\tTYPES: \n\t";
        if(accomodationTypes != null){
            for(int i=0; i<accomodationTypes.size(); i++){
                retVal += accomodationTypes.get(i)+", ";
            }
        }

        retVal += "\tSERVICES: \n\t";
        if(accomodationServices != null) {
            for (int i = 0; i < accomodationServices.size(); i++) {
                retVal += accomodationServices.get(i) + ", ";
            }
        }

        retVal += "\n-------------------------------------------------\n\n";
        return retVal;
    }
}
