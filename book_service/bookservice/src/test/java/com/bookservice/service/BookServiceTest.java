package com.bookservice.service;

import com.bookservice.entity.Book;
import com.bookservice.pojo.SubscriptionDTO;
import com.bookservice.repo.BookRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

  @InjectMocks
  BookService bookService;

  @Mock
  BookRepo bookRepo;

  @Test
  public void getAllBooks(){
    Mockito.when(bookRepo.findAll()).thenReturn(createBooksStub());
    List<Book> bookList  = bookService.getAllBooks();
    Assertions.assertEquals(bookList.get(0).getBookId(),"testBook");
  }

  @Test
  public void checkBookAvailable(){
    Mockito.when(bookRepo.findById(Mockito.any())).thenReturn(createBookStub());
    SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
    subscriptionDTO.setBookId("book");
    SubscriptionDTO service = bookService.checkBookAvailable(subscriptionDTO);
    Assertions.assertEquals(service.getBookId(),"testBook1");
  }

  public List<Book> createBooksStub(){
    List<Book> bookList = new ArrayList<>();
    Book  book = new Book();
    book.setBookId("testBook");
    book.setBookName("testBookName");
    bookList.add(book);
    return bookList;
  }

  public Optional<Book> createBookStub(){
    Book  book = new Book();
    book.setBookId("testBook1");
    book.setBookName("testBookName1");
    book.setAvailableCopies(2);
    return Optional.of(book);
  }

}
