package com.xml.booking.service;

import com.xml.booking.domain.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    public Reservation createReservation(Reservation reservation);
    public Reservation cancelReservation(int reservationId);

    public List<Reservation> getAllByUsernameActive(String name);
    public List<Reservation> getAllByUsernameInActive(String name);

    public Reservation activateReservation(int reservationId);
}
