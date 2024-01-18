package com.subscriptionservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
  private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

  @GetMapping(value = "resilience-test")
  //@RateLimiter(name="default")
  public String resilience(){
    logger.info("Log:subscription service: Resilience demo");
    return "Resilience demo";

  }

}
