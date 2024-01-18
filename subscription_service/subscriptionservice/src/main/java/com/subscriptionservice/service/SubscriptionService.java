package com.subscriptionservice.service;
import com.subscriptionservice.entity.Subscription;
import com.subscriptionservice.pojo.SubscriptionDTO;
import com.subscriptionservice.repo.SubscriptionRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
  @Autowired
  SubscriptionRepo subscriptionRepo;

  //@Autowired
  ModelMapper modelMapper = new ModelMapper();

  public List<Subscription> getAllSubscription(String subscriberName){
    if(subscriberName != null){
      return (List<Subscription>) subscriptionRepo.findAllById(
          Collections.singleton(subscriberName));
    }
    return (List<Subscription>) subscriptionRepo.findAll();
  }

  @Transactional
  @CircuitBreaker(name = "subscriptionService",fallbackMethod = "fallBackMethodForSubscription")
  public String saveSubscription(SubscriptionDTO subscriptionDTO){
    RestTemplateProvider restTemplateProvider = new RestTemplateProvider();
    ResponseEntity<SubscriptionDTO> result = restTemplateProvider.getBookData(subscriptionDTO);
    System.out.println(result.getBody());
    if(result.getBody() != null && result.getBody().getBookId() == null){
      return "Book Not found";
    }else{
      Subscription subscription = modelMapper.map(Objects.requireNonNull(result.getBody()), Subscription.class);
      subscriptionRepo.save(subscription);
      return "Subscription successful";
    }
  }

  public String fallBackMethodForSubscription(SubscriptionDTO subscriptionDTO, Throwable throwable) {
    return "Book service is down. Please try after some time";
  }

}
