package com.xml.booking.dto;

import com.xml.booking.domain.Reservation;

import java.util.Date;

public class ReservationDTO {
    int id;
    int accomodationId;
    int numPersons;
    float finalPrice;
    Date startDate;
    Date endDate;
    String accomodationName;
    String accomodationAddress;


    public ReservationDTO() {

    }
    public ReservationDTO(Reservation reservation) {
        this.accomodationId = reservation.getAccomodation().getAccommodationId();
        this.id = reservation.getReservationId();
        this.numPersons = reservation.getNumPersons();
        this.finalPrice = reservation.getFinalPrice();
        this.startDate = reservation.getStartDate();
        this.endDate = reservation.getEndDate();
        this.accomodationName = reservation.getAccomodation().getName();
        this.accomodationAddress = reservation.getAccomodation().getLocation().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(int accomodationId) {
        this.accomodationId = accomodationId;
    }

    public int getNumPersons() {
        return numPersons;
    }

    public void setNumPersons(int numPersons) {
        this.numPersons = numPersons;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAccomodationName() {
        return accomodationName;
    }

    public void setAccomodationName(String accomodationName) {
        this.accomodationName = accomodationName;
    }

    public String getAccomodationAddress() {
        return accomodationAddress;
    }

    public void setAccomodationAddress(String accomodationAddress) {
        this.accomodationAddress = accomodationAddress;
    }
}
