package com.raspay.wsraspayapi.repository;

import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
