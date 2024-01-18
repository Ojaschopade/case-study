package com.bookservice.controller;

import com.bookservice.pojo.SubscriptionDTO;
import com.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/demo")
public class BookController {

  @Autowired
  BookService bookService;

  @GetMapping(value="/books")
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<?> getBook(){
    return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
  }

  @PostMapping(value="/checkBookAvailable",consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<SubscriptionDTO> checkBookAvailable(@RequestBody SubscriptionDTO subscriptionDTO){
    System.out.println("In Book service..");
    return new ResponseEntity<>(bookService.checkBookAvailable(subscriptionDTO),HttpStatus.OK);
  }

}
