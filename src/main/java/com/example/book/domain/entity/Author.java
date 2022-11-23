package com.example.book.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private Integer id;
    private String authorName;
}
