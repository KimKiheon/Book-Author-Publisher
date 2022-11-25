package com.example.book.service;

import com.example.book.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }
}
