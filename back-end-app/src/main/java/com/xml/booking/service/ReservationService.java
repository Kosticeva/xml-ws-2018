package com.xml.booking.service;

import com.xml.booking.domain.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    public Reservation createReservation(Reservation reservation);
    public Reservation cancelReservation(int reservationId);
}
