package com.xml.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.booking.domain.Review;
import com.xml.booking.repository.AccomodationRepository;
import com.xml.booking.repository.ReviewRepository;
import com.xml.booking.repository.UserRepository;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    UserRepository userRepository;

    public Review allowReview(Review review, boolean allow) {
        Optional<Review> optional = this.reviewRepository.findById(review.getReviewId());
        if (!optional.isPresent()) return null;
        Review r = optional.get();
        r.setAllowed(allow);
        return this.reviewRepository.save(r);
    }

    public List<Review> getReviewsByAllowed(boolean allowed) {
        return this.reviewRepository.findByAllowed(allowed);
    }

    @Transactional
    public Review createReview(Review review) {
        if(review.getGrade() > 5 || review.getGrade() < 1){
            return null;
        }

        if(accomodationRepository.getOne(review.getAccomodation().getAccommodationId()) == null){
            return null;
        }

        if(userRepository.getOne(review.getUser().getUsername()) == null){
            return null;
        }

        if(review.isAllowed() != null && review.isAllowed()){
            return null;
        }

        return reviewRepository.save(review);
    }

    public Review editReview(Review review) {
        if(review.getGrade() > 5 || review.getGrade() < 1){
            return null;
        }

        if(accomodationRepository.getOne(review.getAccomodation().getAccommodationId()) == null){
            return null;
        }

        if(userRepository.getOne(review.getUser().getUsername()) == null){
            return null;
        }

        if(review.isAllowed() == null) {
            return null;
        }

        return reviewRepository.save(review);
    }

    public Review getReview(int reviewId) {
        return reviewRepository.getOne(reviewId);
    }

    public List<Review> getAllReviewsForPlace(int accommodationId) {
        return  reviewRepository.findByAccomodation_AccommodationId(accommodationId);
    }

    public List<Review> getAll(){
        return this.reviewRepository.findAll();
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public double calculateAverageGrade(int accommodationId) {
        List<Review> reviews = getAllReviewsForPlace(accommodationId);

        if(reviews.size() > 0) {
            double sum = 0.0;
            for (Review r : reviews) {
                sum += r.getGrade();
            }

            return sum / reviews.size();
        }

        return 0.0;
    }

}
