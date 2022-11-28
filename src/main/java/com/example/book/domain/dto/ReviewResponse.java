package com.example.book.domain.dto;

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
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String message;

}
