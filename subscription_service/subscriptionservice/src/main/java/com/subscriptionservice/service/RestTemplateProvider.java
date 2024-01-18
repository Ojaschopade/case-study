package com.subscriptionservice.service;

import com.subscriptionservice.pojo.SubscriptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateProvider {
  RestTemplate rest = new RestTemplate();


  public ResponseEntity<SubscriptionDTO> getBookData(SubscriptionDTO subscriptionDTO)
  {
    return rest.postForEntity(
        "http://localhost:8080/checkBookAvailable", subscriptionDTO,
        SubscriptionDTO.class);
  }

}
