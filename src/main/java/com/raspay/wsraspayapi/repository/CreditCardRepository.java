package com.raspay.wsraspayapi.repository;

import com.raspay.wsraspayapi.model.CreditCard;
import com.raspay.wsraspayapi.model.Custumer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard,String> {
}
