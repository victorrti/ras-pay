package com.raspay.wsraspayapi.service;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.model.Custumer;
import reactor.core.publisher.Mono;

public interface CustumerService {

    Mono<Custumer> create(CustumerDto dto);
}
