package com.group.libraryapp.dto.book.request;


import lombok.Data;

public class BookCreateRequest {

    private String name;

    public BookCreateRequest() {
    }

    public BookCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


