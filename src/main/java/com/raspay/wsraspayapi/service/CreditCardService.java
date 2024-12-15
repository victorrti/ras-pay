package com.raspay.wsraspayapi.service;

import com.raspay.wsraspayapi.dto.CreditCardDto;
import com.raspay.wsraspayapi.model.CreditCard;
import com.raspay.wsraspayapi.model.Custumer;
import reactor.core.publisher.Mono;

public interface CreditCardService {
    Mono<CreditCard> findByNumber(String number);
    Mono<CreditCard> create(CreditCardDto creditCardDto, Custumer custumer);
}
