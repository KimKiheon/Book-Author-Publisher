package com.example.book.domain.dto;

import com.example.book.domain.entity.Hospital;
import com.example.book.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewRequest {
    private Long hospitalId;
    private String title;
    private String content;
    private String userName;

    public Review toEntity(Hospital hospital){
        Review review = Review.builder()
                .title(this.title)
                .content(this.content)
                .userName(this.userName)
                .hospital(hospital)
                .build();
        return review;
    }
}
