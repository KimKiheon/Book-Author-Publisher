package com.example.book.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    @Id
    private Integer id;
    private String name;
}
