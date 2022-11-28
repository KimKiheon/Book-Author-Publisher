package com.example.book.controller;

import com.example.book.domain.dto.ReviewRequest;
import com.example.book.domain.dto.ReviewResponse;
import com.example.book.service.HospitalService;
import com.example.book.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final ReviewService reviewService;
    private final HospitalService hospitalService;
    public HospitalController(ReviewService reviewService, HospitalService hospitalService) {
        this.reviewService = reviewService;
        this.hospitalService = hospitalService;
    }

    @PostMapping("/{id}/reviews/add") //리뷰 추가
    public ResponseEntity<ReviewResponse> add(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest){
        ReviewResponse reviewResponse = reviewService.add(reviewRequest);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/reviews/{id}") //리뷰 id로 조회
    public ResponseEntity<ReviewResponse> findByIdReview(@PathVariable Long id){
        ReviewResponse reviewResponse = reviewService.get(id);
        return ResponseEntity.ok().body(reviewResponse);
    }
    //병원 id로 리뷰 조회
    @ApiOperation(value = "병원 ID로 병원 리뷰 조회")
    @GetMapping("/{id}/reviews/get")
    public ResponseEntity<List<ReviewResponse>> findByIdReviewList(@PathVariable Long id){
        List<ReviewResponse> reviewResponses = reviewService.getHospitalReview(id);
        return ResponseEntity.ok().body(reviewResponses);
    }
}
