package com.xml.booking.service;

import com.xml.booking.agent.rest.dto.AgentReservationDTO;
import com.xml.booking.domain.Reservation;
import com.xml.booking.domain.User;
import com.xml.booking.dto.ReservationDTO;
import com.xml.booking.repository.AccomodationRepository;
import com.xml.booking.repository.ReservationRepository;
import com.xml.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccomodationRepository accomodationRepository;

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
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation saveDTO(AgentReservationDTO agentRreservationDTO) {
        Reservation r = new Reservation();
        r.setReservationId(0);
        r.setActive(true);
        r.setAccomodation(accomodationRepository.findById(agentRreservationDTO.getId()).get());

        Date startDate = new Date();
        Date endDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            startDate = simpleDateFormat.parse(agentRreservationDTO.getStartDate());
            endDate = simpleDateFormat.parse(agentRreservationDTO.getEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        r.setStartDate(startDate);
        r.setEndDate(endDate);
        r.setRealized(true);
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation get(int id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllByUsernameActive(String username) {
        User user = userRepository.findById(username).orElse(null);
        return reservationRepository.findByUserAndActiveAndRealized(user, true, false);
    }
    @Override
    public List<Reservation> getAllByUsernameInActive(String username) {
        User user = userRepository.findById(username).orElse(null);
        return reservationRepository.findByUserAndActiveAndRealized(user, false, false);
    }
    @Override
    public List<Reservation> getAllByUsernameRealized(String username) {
        User user = userRepository.findById(username).orElse(null);
        return reservationRepository.findByUserAndRealized(user, true);
    }
}
