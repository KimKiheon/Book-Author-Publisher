package com.example.book.service;

import com.example.book.domain.dto.ReviewRequest;
import com.example.book.domain.dto.ReviewResponse;
import com.example.book.domain.entity.Hospital;
import com.example.book.domain.entity.Review;
import com.example.book.repository.HospitalRepository;
import com.example.book.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return new ReviewResponse(savedReview.getHospital().getHospitalName(), savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(), "리뷰 등록");
    }
    public ReviewResponse get(Long reviewId) {
        Optional<Review> optReview = reviewRepository.findById(reviewId);
        Review selectReview = optReview.get();

        return new ReviewResponse(selectReview.getHospital().getHospitalName(), selectReview.getId(), selectReview.getUserName(),
                selectReview.getTitle(), selectReview.getContent(), "1개 조회 완료");

    }
    public List<ReviewResponse> getHospitalReview(Long hospitalId){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        List<Review> reviewList = optionalHospital.get().getReviews();
        List<ReviewResponse> reviewResponses = reviewList.stream()
                .map(review -> ReviewResponse.of(review))
                .collect(Collectors.toList());
        return reviewResponses;
    }
}
