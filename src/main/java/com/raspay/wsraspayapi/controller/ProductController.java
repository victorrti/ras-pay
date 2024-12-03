package com.raspay.wsraspayapi.controller;

import com.raspay.wsraspayapi.dto.ProductDto;
import com.raspay.wsraspayapi.model.Product;
import com.raspay.wsraspayapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Mono<Void>> create(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productDto).then());
    }
    @GetMapping
    public ResponseEntity<Flux<Product>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{acronym}")
    public ResponseEntity<Mono<Product>> findByAcronym(@PathVariable String acronym){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findByAcronym(acronym));
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<Flux<Product>> findAllByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findByName(name));
    }
    @GetMapping("/params")
    public  ResponseEntity<Flux<Product>> findAllByParams(@RequestParam(value = "name",required = false,defaultValue = "") String name,@RequestParam(value = "acronym",required = false,defaultValue = "") String acronym,@RequestParam(value = "currentPrice",required = false,defaultValue = "") String currentPrice){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllByParams(acronym,name,currentPrice));
    }
}
