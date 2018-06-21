package com.xml.booking.controllers;

import com.xml.booking.domain.Reservation;
import com.xml.booking.dto.ReservationDTO;
import com.xml.booking.service.AccomodationService;
import com.xml.booking.service.ReservationService;
import com.xml.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservation")
public class ResevationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccomodationService accomodationSerService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/create",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO, Principal user) {
        Reservation reservation = new Reservation();
        reservation.setAccomodation(accomodationSerService.get(reservationDTO.getAccomodationId()));
        reservation.setRealized(false);
        reservation.setActive(true);
        reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setEndDate(reservationDTO.getEndDate());
        reservation.setFinalPrice(reservationDTO.getFinalPrice());
        reservation.setNumPersons(reservationDTO.getNumPersons());
        reservation.setUser(userService.findUser(user.getName()));
        return new ResponseEntity<ReservationDTO>(new ReservationDTO(reservationService.createReservation(reservation)), HttpStatus.OK);
    }


    @RequestMapping(
            value = "/cancel/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReservationDTO> cancelReservation(@PathVariable("id") int id) {
        return new ResponseEntity<ReservationDTO>(new ReservationDTO(reservationService.cancelReservation(id)), HttpStatus.OK);
    }
    @RequestMapping(
            value = "/activate/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReservationDTO> activateReservation(@PathVariable("id") int id) {
        return new ResponseEntity<ReservationDTO>(new ReservationDTO(reservationService.activateReservation(id)), HttpStatus.OK);
    }

    @RequestMapping(
            value = "getbyuseractive/{username}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ReservationDTO>> getAllByUserActive(@PathVariable("username") String username, Principal user) {
        List<Reservation> reservations = reservationService.getAllByUsernameActive(user.getName());
        List<ReservationDTO> reservationDTOS = new ArrayList<ReservationDTO>();
        for (Reservation r : reservations) {
            reservationDTOS.add(new ReservationDTO(r));
        }
        return new ResponseEntity<List<ReservationDTO>>(reservationDTOS, HttpStatus.OK);
    }
    @RequestMapping(
            value = "getbyuserinactive/{username}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ReservationDTO>> getAllByUserInActive(@PathVariable("username") String username, Principal user) {
        List<Reservation> reservations = reservationService.getAllByUsernameInActive(user.getName());
        List<ReservationDTO> reservationDTOS = new ArrayList<ReservationDTO>();
        for (Reservation r : reservations) {
            reservationDTOS.add(new ReservationDTO(r));
        }
        return new ResponseEntity<List<ReservationDTO>>(reservationDTOS, HttpStatus.OK);
    }

}
