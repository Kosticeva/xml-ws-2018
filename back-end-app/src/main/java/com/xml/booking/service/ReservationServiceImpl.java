package com.xml.booking.service;

import com.xml.booking.domain.Reservation;
import com.xml.booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation cancelReservation(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        reservation.setActive(false);
        reservationRepository.save(reservation);
        return reservation;
    }
}
