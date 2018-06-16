package com.xml.booking.repository;

import com.xml.booking.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<Review> findByAccomodation_AccommodationId(int accommodationId);
    public List<Review> findByAllowed(boolean allowd);

}
