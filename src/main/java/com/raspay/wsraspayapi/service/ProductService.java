package com.raspay.wsraspayapi.service;

import com.raspay.wsraspayapi.dto.ProductDto;
import com.raspay.wsraspayapi.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> create(ProductDto dto);

    Flux<Product> findAll();

    Mono<Product> findByAcronym(String acronym);

    Flux<Product> findByName(String name);

    Flux<Product> findAllByParams(String name,String acronym,String currentPrice);
}
