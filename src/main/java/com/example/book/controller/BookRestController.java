package com.example.book.controller;

import com.example.book.domain.dto.BookResponse;
import com.example.book.domain.entity.Book;
import com.example.book.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {
    BookService bookService;
    public BookRestController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable){
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id){
        return ResponseEntity.ok().body(new Book());
    }
}