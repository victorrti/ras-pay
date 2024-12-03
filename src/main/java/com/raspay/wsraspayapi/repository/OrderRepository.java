package com.raspay.wsraspayapi.repository;

import com.raspay.wsraspayapi.model.CreditCard;
import com.raspay.wsraspayapi.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
}
