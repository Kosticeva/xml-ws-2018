package com.xml.booking.service;

import com.xml.booking.agent.rest.dto.AgentReservationDTO;
import com.xml.booking.domain.Reservation;
import com.xml.booking.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    Reservation cancelReservation(int reservationId);

    List<Reservation> getAllByUsernameActive(String name); //ne vraca realizovane
    List<Reservation> getAllByUsernameInActive(String name); //ne vraca realizovane
    List<Reservation> getAllByUsernameRealized(String name);

    Reservation activateReservation(int reservationId);
    Reservation save(Reservation reservation);
    Reservation saveDTO(AgentReservationDTO reservationDTO);
    List<Reservation> findAll();
    Reservation get(int id);
    void delete(int id);
}
