package com.group.libraryapp.repository.book;

import com.group.libraryapp.domain.book.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookMemoryRepository implements BookRepository{

    private final List<Book> books = new ArrayList<>();


    @Override
    public void saveBook(Book book){
        books.add(book);

    }


    @Override
    public void deleteBook(Book book){
        books.remove(book);
    }

    public void update(Book book){

    }
}
