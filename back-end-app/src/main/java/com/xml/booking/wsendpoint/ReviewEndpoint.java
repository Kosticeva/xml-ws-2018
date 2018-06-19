package com.xml.booking.wsendpoint;

import com.xml.booking.domain.Review;
import com.xml.booking.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ws.ReviewRequest;
import ws.ReviewResponse;

@Endpoint
public class ReviewEndpoint {

	@Autowired
	ReviewRepository reviewRepository;

	@PayloadRoot(namespace = "ws", localPart = "ReviewRequest")
	@ResponsePayload
	public ReviewResponse getReview(@RequestPayload ReviewRequest request) {
		ReviewResponse response = new ReviewResponse();
		Review review = reviewRepository.findById(request.getReviewId()).get();
		response.setReview(review);
		return response;
	}

}
