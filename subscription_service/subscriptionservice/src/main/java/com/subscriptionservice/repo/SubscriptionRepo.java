package com.subscriptionservice.repo;

import com.subscriptionservice.entity.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription,String> {

}
