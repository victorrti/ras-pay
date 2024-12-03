package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.ProductDto;
import com.raspay.wsraspayapi.mapper.ProductMapper;
import com.raspay.wsraspayapi.model.Product;
import com.raspay.wsraspayapi.repository.ProductRepository;
import com.raspay.wsraspayapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ReactiveMongoTemplate mongoTemplate;


    @Override
    public Mono<Product> create(ProductDto dto) {
        return productRepository.save(productMapper.toModel(dto));
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findByAcronym(String acronym) {
        return productRepository.findByAcronym(acronym);
    }

    @Override
    public Flux<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Flux<Product> findAllByParams(String name, String acronym, String currentPrice) {
        Criteria criteria = new Criteria();
        if(!Objects.equals(acronym,"")){
            criteria.and("acronym").is(acronym);
        }
        if(!Objects.equals(name,"")){
            criteria.and("name").regex("^"+name,"i");
        }
        if(!Objects.equals(acronym,"")){
            criteria.and("currentPrice").is(currentPrice);
        }
        Query query = new Query();
        query.addCriteria(criteria);

         return mongoTemplate.find(query,Product.class);
    }
}
