package com.bookservice.service;

import com.bookservice.entity.Book;
import com.bookservice.pojo.SubscriptionDTO;
import com.bookservice.repo.BookRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  BookRepo bookRepo;

  public List<Book> getAllBooks(){
    return (List<Book>) bookRepo.findAll();
  }

  public SubscriptionDTO checkBookAvailable(SubscriptionDTO subscriptionDTO){
    Optional<Book> result = bookRepo.findById(subscriptionDTO.getBookId());
    //Subscription pojo = new Subscription();

    if(result.isPresent() && result.get().getAvailableCopies() != null && result.get().getAvailableCopies() !=0){
      Book bookRes = result.get();
      subscriptionDTO.setBookId(bookRes.getBookId());
    }else{
      subscriptionDTO = new SubscriptionDTO();
    }
    return subscriptionDTO;
  }

}
