package com.raspay.wsraspayapi.repository;

import com.raspay.wsraspayapi.model.Custumer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustumerRepository extends ReactiveMongoRepository<Custumer,String> {
}
