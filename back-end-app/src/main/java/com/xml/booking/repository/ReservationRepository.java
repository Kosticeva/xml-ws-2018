package com.xml.booking.repository;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Reservation;
import com.xml.booking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByAccomodationAndStartDateBeforeAndEndDateAfter
            (Accomodation accomodation, Date startDate, Date endDate);

    List<Reservation> findByUserAndActiveAndRealized(User user, boolean active, boolean realized);

    List<Reservation> findByUser(User user);

    List<Reservation> findByUserAndRealized(User user, boolean realized);
}
