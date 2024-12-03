package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.ProductDto;
import com.raspay.wsraspayapi.mapper.ProductMapper;
import com.raspay.wsraspayapi.model.Product;
import com.raspay.wsraspayapi.repository.ProductRepository;
import com.raspay.wsraspayapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

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
}
