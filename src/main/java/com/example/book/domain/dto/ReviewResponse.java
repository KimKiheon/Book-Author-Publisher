package com.example.book.domain.dto;

import com.example.book.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private String hospitalName;
    private Long reviewId;
    private String title;
    private String content;
    private String userName;
    private String message;
    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .hospitalName(review.getHospital().getHospitalName())
                .reviewId(review.getId())
                .userName(review.getUserName())
                .title(review.getTitle())
                .content(review.getContent())
                .message("해당 병원 리뷰 조회 완료")
                .build();
    }

}
