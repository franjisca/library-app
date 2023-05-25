package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository,
                       UserRepository userRepository
    ) {

        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }



    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 책정보
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);


        // 대출기록 정보를 확인해서 대출중인지
        // 만약 확인했는데 대출중이라면 예외를 발생
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false)){
            throw new IllegalArgumentException("대출 중인 책입니다.");
        }

        // 유저 정보 가져오기

        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);

        user.loanBook(request.getBookName());
    }


    @Transactional
    public void returnBook(BookReturnRequest request) {

        // 이름 있는지, 책 있는지
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);

        // 정보 찾아오기

        user.returnBook(request.getBookName());
    }
}
