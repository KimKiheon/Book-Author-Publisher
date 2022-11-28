package com.example.book.controller;

import com.example.book.domain.dto.ReviewRequest;
import com.example.book.domain.dto.ReviewResponse;
import com.example.book.service.HospitalService;
import com.example.book.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final ReviewService reviewService;
    private final HospitalService hospitalService;
    public HospitalController(ReviewService reviewService, HospitalService hospitalService) {
        this.reviewService = reviewService;
        this.hospitalService = hospitalService;
    }

    @PostMapping("/{id}/reviews/add")
    public ResponseEntity<ReviewResponse> add(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest){
        ReviewResponse reviewResponse = reviewService.add(reviewRequest);
        return ResponseEntity.ok().body(reviewResponse);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponse> findByIdReview(@PathVariable Long id){
        ReviewResponse reviewResponse = reviewService.get(id);
        return ResponseEntity.ok().body(reviewResponse);
    }
}
