package com.xml.booking.dto;

import com.xml.booking.domain.Reservation;

import java.util.Date;

public class ReservationDTO {
    int reservationId;
    int accomodationId;
    int numPersons;
    float finalPrice;
    Date startDate;
    Date endDate;


    public ReservationDTO() {

    }
    public ReservationDTO(Reservation reservation) {
        this.accomodationId = reservation.getAccomodation().getAccommodationId();
        this.reservationId = reservation.getReservationId();
        this.numPersons = reservation.getNumPersons();
        this.finalPrice = reservation.getNumPersons();
        this.startDate = reservation.getStartDate();
        this.endDate = reservation.getEndDate();
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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
}
