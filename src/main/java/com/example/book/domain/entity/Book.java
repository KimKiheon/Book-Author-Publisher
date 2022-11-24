package com.example.book.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
