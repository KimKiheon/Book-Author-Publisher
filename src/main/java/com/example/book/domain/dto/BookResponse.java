package com.example.book.domain.dto;

import com.example.book.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private Integer bookId;
    private String bookName;
    private String Name;
    public static BookResponse of(Book book, String name){
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .Name(name)
                .build();
    }
}