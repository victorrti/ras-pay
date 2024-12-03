package com.raspay.wsraspayapi.repository;

import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

    Mono<Product> findByAcronym(String acronym);
}
