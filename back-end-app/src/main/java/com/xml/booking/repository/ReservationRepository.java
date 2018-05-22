package com.xml.booking.repository;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    public List<Reservation> findByAccomodationAndStartDateBeforeAndEndDateAfter
            (Accomodation accomodation, Date startDate, Date endDate);
}
