package com.raspay.wsraspayapi.controller;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.dto.OrderDto;
import com.raspay.wsraspayapi.model.Order;
import com.raspay.wsraspayapi.service.CustumerService;
import com.raspay.wsraspayapi.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
  @PostMapping
    public ResponseEntity<Mono<Order>> create(@Valid  @RequestBody OrderDto dto){

      return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(dto));
  }
}
