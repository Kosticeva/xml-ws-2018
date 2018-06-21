package com.xml.booking.review.repository;

import com.xml.booking.review.dto.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    List<Review> findByAccomodationId(Integer accomodationId);
    List<Review> findByAllowed(Boolean allowd);
    List<Review> findByAccomodationIdAndGrade(Integer accomodationId, Integer grade);
}
