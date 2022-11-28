package com.example.book.service;

import com.example.book.domain.dto.HospitalResponse;
import com.example.book.domain.entity.Hospital;
import com.example.book.domain.entity.Review;
import com.example.book.repository.HospitalRepository;
import com.example.book.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;
    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository){
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }
    public HospitalResponse findHospital(Long id) {
        Optional<Hospital> hospitals = hospitalRepository.findById(id);
        List<Review> reviews = reviewRepository.findByHospital_Id(hospitals.get().getId());
        return new HospitalResponse();
    }
}
