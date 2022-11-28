package com.example.book.domain.dto;

import com.example.book.domain.entity.Hospital;
import com.example.book.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Long hospitalId;
    private String hospitalName;
    private String hospitalRoadNameAddress;
    private List<Review> reviews;
    public static HospitalResponse of(Hospital hospital) {
        return HospitalResponse.builder()
                .hospitalId(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .hospitalRoadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews())
                .build();
    }
}
