package com.xml.booking.repository;

import com.xml.booking.domain.Accomodation;
import com.xml.booking.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<Review> findByAccomodation(Accomodation accomodation);
    public List<Review> findByAllowed(boolean allowd);

}
