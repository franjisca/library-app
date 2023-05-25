package com.group.libraryapp.domain.book;


import com.group.libraryapp.dto.book.request.BookCreateRequest;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Book() {
    }

    public Book(String name) {

        if(name == null || name.isBlank()) {
            throw  new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }
        this.name = name;
    }

    @Column(nullable = false)
    private String name;

}
