package com.raspay.wsraspayapi.service;

import com.raspay.wsraspayapi.dto.PaymentDto;
import com.raspay.wsraspayapi.model.Payment;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<Payment> process(PaymentDto dto);
}
