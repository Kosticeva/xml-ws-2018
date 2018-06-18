package com.xml.booking.dto;

import java.io.Serializable;
import java.util.List;

public class AccomodationDTO implements Serializable {

    private String agentUsername;

    private String address;
    private String city;
    private String country;

    private String name;
    private String description;
    private float averageGrade;

    private String categoryName;
    private String type;

    private List<String> services;
    private Float price;

    private int accomodationId;

    public AccomodationDTO() {}

    public AccomodationDTO(String agentUsername, String address, String city, String country, String name, String description, float averageGrade, String categoryName, String type, List<String> services, float price, int accomodationId) {
        this.agentUsername = agentUsername;
        this.address = address;
        this.city = city;
        this.country = country;
        this.name = name;
        this.description = description;
        this.averageGrade = averageGrade;
        this.categoryName = categoryName;
        this.type = type;
        this.services = services;
        this.price = price;
        this.accomodationId = accomodationId;
    }

    public String getAgentUsername() {
        return agentUsername;
    }

    public void setAgentUsername(String agentUsername) {
        this.agentUsername = agentUsername;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(int accomodationId) {
        this.accomodationId = accomodationId;
    }
}
