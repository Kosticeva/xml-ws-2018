package com.xml.booking.service;

import com.xml.booking.domain.Reservation;
import com.xml.booking.domain.User;
import com.xml.booking.repository.ReservationRepository;
import com.xml.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;

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
    @Override
    public Reservation activateReservation(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        reservation.setActive(true);
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> getAllByUsernameActive(String username) {
        User user = userRepository.findById(username).orElse(null);
        return reservationRepository.findByUserAndActive(user, true);
    }
    @Override
    public List<Reservation> getAllByUsernameInActive(String username) {
        User user = userRepository.findById(username).orElse(null);
        return reservationRepository.findByUserAndActive(user, false);
    }
}
