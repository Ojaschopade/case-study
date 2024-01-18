package com.subscriptionservice.controller;

import com.subscriptionservice.entity.Subscription;
import com.subscriptionservice.pojo.SubscriptionDTO;
import com.subscriptionservice.service.SubscriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

  @Autowired
  SubscriptionService subscriptionService;

  @GetMapping(value="/subscriptions")
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<?> getSubscriptions(@RequestParam(required = false) String subscriberName){
    List<Subscription> subscriptions = subscriptionService.getAllSubscription(subscriberName);
    if(subscriptions.size() == 0){
      return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(subscriptions,HttpStatus.OK);
  }

  @PostMapping(value="/saveSubscription",consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<?> saveSubscription(@RequestBody SubscriptionDTO subscriptionDTO){
    String message = subscriptionService.saveSubscription(subscriptionDTO);
    if(message.equalsIgnoreCase("Subscription successful")){
      return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
    return new ResponseEntity<>(message,HttpStatus.UNPROCESSABLE_ENTITY);
  }

}
