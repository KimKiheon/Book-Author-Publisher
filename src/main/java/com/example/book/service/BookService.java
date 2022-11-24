package com.example.book.service;

import com.example.book.domain.dto.BookResponse;
import com.example.book.domain.entity.Author;
import com.example.book.domain.entity.Book;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    public List<BookResponse> findBooks(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        log.info(books.getContent().get(0).getName());
        List<BookResponse> bookResponses=books.stream()
                .map(book->{
                    Optional<Author> optionalAuthor=authorRepository.findById(book.getAuthorId());
                    return BookResponse.of(book, optionalAuthor.get().getName());
                }).collect(Collectors.toList());

        return bookResponses;
    }
}