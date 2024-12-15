package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.OrderDto;
import com.raspay.wsraspayapi.exception.BadRequestException;
import com.raspay.wsraspayapi.exception.NotFoundException;
import com.raspay.wsraspayapi.mapper.OrderMapper;
import com.raspay.wsraspayapi.model.Order;
import com.raspay.wsraspayapi.repository.OrderRepository;
import com.raspay.wsraspayapi.service.CustumerService;
import com.raspay.wsraspayapi.service.OrderService;
import com.raspay.wsraspayapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustumerService custumerService;
    private final ProductService productService;

    @Override
    public Mono<Order> create(OrderDto orderDto) {

        return custumerService.findById(orderDto.custumerId())
                .flatMap(custumer -> productService.findByAcronym(orderDto.productAcronym())
                .flatMap(product -> {
                    Order order = orderMapper.toModel(orderDto);
                    if(orderDto.descount().intValue() > 0){
                        if(orderDto.descount().compareTo(product.getCurrentPrice()) > 0){
                            return Mono.error(new BadRequestException("Discount can not be greater than currentPrice"));
                        }
                        order.setOriginalPrice(product.getCurrentPrice().subtract(orderDto.descount()));
                    }
                    order.setProductId(product.getId());
                    order.setCustumerId(custumer.getId());
                    return orderRepository.save(order);
                }));
    }

    @Override
    public Mono<Order> findById(String id) {
        return orderRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("Order not found")));
    }
}
