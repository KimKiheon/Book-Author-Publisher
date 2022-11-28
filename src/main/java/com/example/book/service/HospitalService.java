package com.example.book.service;

import com.example.book.repository.HospitalRepository;
import com.example.book.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;
    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository){
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }
}
