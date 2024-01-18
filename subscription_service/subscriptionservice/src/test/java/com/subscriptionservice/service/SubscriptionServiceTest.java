package com.subscriptionservice.service;

import com.subscriptionservice.entity.Subscription;
import com.subscriptionservice.pojo.SubscriptionDTO;
import com.subscriptionservice.repo.SubscriptionRepo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class SubscriptionServiceTest {

  @InjectMocks
  SubscriptionService subscriptionService;

  @Mock
  SubscriptionRepo subscriptionRepo;

  @InjectMocks
  RestTemplateProvider restTemplateProvider;

  @Mock
  RestTemplate restTemplate;

  @Test
  public void getAllSubscription(){
    Mockito.when(subscriptionRepo.findAll()).thenReturn(createSubscriptionAllStub());
    Mockito.when(subscriptionRepo.findAllById(Mockito.any())).thenReturn(createSubscriptionStub());

    List<Subscription> subscriptionList = subscriptionService.getAllSubscription("B4232");
    List<Subscription> subscriptionListWithEmptyBook = subscriptionService.getAllSubscription(null);
    Assertions.assertEquals(subscriptionList.get(0).getBookId(),"bookTest1");
    Assertions.assertEquals(subscriptionListWithEmptyBook.get(0).getBookId(),"bookTest");
  }

  public List<Subscription> createSubscriptionAllStub(){
    List<Subscription> subscriptionList = new ArrayList<>();
    Subscription subscription = new Subscription();
    subscription.setBookId("bookTest");
    subscription.setSubscriberName("subNameTest");
    subscriptionList.add(subscription);
    return subscriptionList;
  }

  public List<Subscription> createSubscriptionStub(){
    List<Subscription> subscriptionList = new ArrayList<>();
    Subscription subscription = new Subscription();
    subscription.setBookId("bookTest1");
    subscription.setSubscriberName("subNameTest1");
    subscriptionList.add(subscription);
    return subscriptionList;
  }

  /*@Test
  public void checkBookAvailable(){
    ResponseEntity mocResponse = new ResponseEntity("Subscription successful", HttpStatus.OK);

    SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
    subscriptionDTO.setBookId("test");
//    Mockito.when(restTemplateProvider.getBookData(Mockito.any())).thenReturn(mocResponse);
    Mockito.when(restTemplate.postForEntity(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(mocResponse);
    String result = subscriptionService.checkBookAvailable(subscriptionDTO);
    Assertions.assertEquals("Subscription successful",result);
  }*/

}
