package com.xml.booking.review.service;

import com.xml.booking.review.domain.Accomodation;
import com.xml.booking.review.domain.Review;
import com.xml.booking.review.dto.ReviewDTO;
import com.xml.booking.review.repository.AccomodationRepository;
import com.xml.booking.review.repository.ReviewRepository;
import com.xml.booking.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AccomodationRepository accomodationRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public ReviewDTO createReview(ReviewDTO review) {
        if(review.getGrade() > 5 || review.getGrade() < 1){
            return null;
        }

        if(accomodationRepository.getOne(review.getAccomodationId()) == null){
            return null;
        }

        if(userRepository.getOne(review.getUser()) == null){
            return null;
        }

        if(review.isAllowed() != null && review.isAllowed()){
            return null;
        }

        List<ReviewDTO> dtos = new ArrayList<>();
        dtos.add(review);
        Review r = mapFromDTO(dtos).get(0);
        r = reviewRepository.save(r);
        List<Review> revs = new ArrayList<>();
        revs.add(r);
        return mapToDTO(revs).get(0);
    }

    public ReviewDTO editReview(ReviewDTO review) {
        if(review.getGrade() > 5 || review.getGrade() < 1){
            return null;
        }

        if(accomodationRepository.getOne(review.getAccomodationId()) == null){
            return null;
        }

        if(userRepository.getOne(review.getUser()) == null){
            return null;
        }

        if(review.isAllowed() == null) {
            return null;
        }

        List<ReviewDTO> dtos = new ArrayList<>();
        dtos.add(review);
        Review r = mapFromDTO(dtos).get(0);
        r = reviewRepository.save(r);
        List<Review> revs = new ArrayList<>();
        revs.add(r);
        return mapToDTO(revs).get(0);
    }

    public ReviewDTO getReview(int reviewId) {
        List<Review> reviews = new ArrayList<>();
        reviews.add(reviewRepository.getOne(reviewId));
        return mapToDTO(reviews).get(0);
    }

    public List<ReviewDTO> getAllReviewsForPlace(int accommodationId) {
        Optional<Accomodation> aa = accomodationRepository.findById(accommodationId);
        if(aa.isPresent())
            return  mapToDTO(reviewRepository.findByAccomodation(aa.get()));

        return null;
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public float calculateAverageGrade(int accommodationId) {
        List<ReviewDTO> reviews = getAllReviewsForPlace(accommodationId);

        float sum = 0.0F;
        if(reviews.size() > 0) {
            for (ReviewDTO r : reviews) {
                sum += r.getGrade();
            }

            return sum / reviews.size();
        }

        return sum;
    }


    public Review allowReview(Review review, boolean allow) {
        Optional<Review> optional = this.reviewRepository.findById(review.getReviewId());
        if (!optional.isPresent()) return null;
        Review r = optional.get();
        r.setAllowed(allow);
        return this.reviewRepository.save(r);
    }

    public List<ReviewDTO> getReviewsByAllowed(boolean allowed) {
       return mapToDTO(this.reviewRepository.findByAllowed(allowed));
    }

    public List<ReviewDTO> getAll(){
        return mapToDTO(this.reviewRepository.findAll());

    }

    private List<ReviewDTO> mapToDTO(List<Review> reviews) {
        List<ReviewDTO> dtos = new ArrayList<>();

        for(Review r: reviews){
            ReviewDTO dto = new ReviewDTO();
            dto.setAccomodationId(r.getAccomodation().getAccommodationId());
            dto.setComment(r.getComment());
            dto.setGrade(r.getGrade());
            dto.setAllowed(r.isAllowed());
            dto.setUser(r.getUser().getUsername());
            dto.setReviewId(r.getReviewId());
            dtos.add(dto);
        }

        return dtos;
    }

    private List<Review> mapFromDTO(List<ReviewDTO> reviewDTOS){
        List<Review> reviews = new ArrayList<>();

        for(ReviewDTO dto: reviewDTOS){
            Review r = new Review();
            r.setAllowed(dto.isAllowed());
            r.setAccomodation(accomodationRepository.findById(dto.getAccomodationId()).get());
            r.setComment(dto.getComment());
            r.setGrade(dto.getGrade());
            r.setReviewId(dto.getReviewId());
            r.setUser(userRepository.findOneByUsername(dto.getUser()));

            reviews.add(r);
        }

        return reviews;
    }

}
