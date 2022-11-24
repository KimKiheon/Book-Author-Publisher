package com.example.book.service;

import com.example.book.domain.dto.BookResponse;
import com.example.book.domain.entity.Book;
import com.example.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookResponse> findBooks(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses=books.stream()
                .map(book->BookResponse.of(book)).collect(Collectors.toList());

        return bookResponses;
    }
}