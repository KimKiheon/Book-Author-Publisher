package com.example.book.service;

import com.example.book.domain.dto.ReviewRequest;
import com.example.book.domain.dto.ReviewResponse;
import com.example.book.domain.entity.Hospital;
import com.example.book.domain.entity.Review;
import com.example.book.repository.HospitalRepository;
import com.example.book.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }
    public ReviewResponse add(ReviewRequest reviewCreateRequest){
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(), "리뷰 등록");
    }
}
