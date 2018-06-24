package com.ftn.xml.agent.repository;

import com.ftn.xml.agent.domain.Accomodation;
import com.ftn.xml.agent.domain.Agent;
import com.ftn.xml.agent.domain.Reservation;
import com.ftn.xml.agent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByAccomodationAndStartDateBeforeAndEndDateAfter
			(Accomodation accomodation, Date startDate, Date endDate);

    List<Reservation> findByUserAndActive(User user, boolean active);

    List<Reservation> findByUser(User user);
}
