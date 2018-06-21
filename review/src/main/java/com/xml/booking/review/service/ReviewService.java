package com.xml.booking.review.service;

import com.xml.booking.review.dto.Review;
import com.xml.booking.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Transactional
    public Review createReview(Review review) {
        if(review.getGrade() > 5 || review.getGrade() < 1){
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

        if(review.isAllowed() == null) {
            return null;
        }
        
        return reviewRepository.save(review);
    }

    public Review getReview(int reviewId) {
        return reviewRepository.getOne(reviewId);
    }

    public List<Review> getAllReviewsForPlace(int accommodationId) {
        return reviewRepository.findByAccomodationId(accommodationId);
    }

    public List<Review> getAllReviewsForPlaceByGrade(Integer accommodationId, Integer grade){
        return reviewRepository.findByAccomodationIdAndGrade(accommodationId, grade);
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public float calculateAverageGrade(int accommodationId) {
        List<Review> reviews = getAllReviewsForPlace(accommodationId);

        float sum = 0.0F;
        if(reviews.size() > 0) {
            for (Review r : reviews) {
                sum += r.getGrade();
            }

            return sum / reviews.size();
        }

        return sum;
    }


    public Review allowReview(Review review, boolean allow) {
        Optional<Review> opt = reviewRepository.findById(review.getReviewId());
        if(!opt.isPresent())
            return null;
        Review r = opt.get();
        r.setAllowed(allow);
        return reviewRepository.save(r);
    }

    public List<Review> getReviewsByAllowed(boolean allowed) {
       return this.reviewRepository.findByAllowed(allowed);
    }

    public List<Review> getAll(){
       return this.reviewRepository.findAll();
    }
    
}
