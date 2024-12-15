package com.raspay.wsraspayapi.repository;

import com.raspay.wsraspayapi.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends ReactiveMongoRepository<Payment,String> {


}
