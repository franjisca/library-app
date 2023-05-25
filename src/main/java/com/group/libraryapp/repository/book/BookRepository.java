package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.book.Book;

public interface BookRepository {

    public void saveBook(Book book);
    public void deleteBook(Book book);
}
