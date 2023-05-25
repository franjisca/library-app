package com.group.libraryapp.repository.book;


import com.group.libraryapp.domain.book.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookMySqlRepository implements BookRepository{

    private final JdbcTemplate jdbcTemplate;

    public BookMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {

    }
}
