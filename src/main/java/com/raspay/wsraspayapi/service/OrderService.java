package com.raspay.wsraspayapi.service;

import com.raspay.wsraspayapi.dto.OrderDto;
import com.raspay.wsraspayapi.model.Order;
import reactor.core.publisher.Mono;

public interface OrderService {
    Mono<Order> create(OrderDto dto);
    Mono<Order> findById(String id);
}
