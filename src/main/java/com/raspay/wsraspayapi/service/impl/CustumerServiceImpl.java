package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.mapper.CustumerMapper;
import com.raspay.wsraspayapi.mapper.ProductMapper;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.repository.CustumerRepository;
import com.raspay.wsraspayapi.service.CustumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustumerServiceImpl implements CustumerService {
    private final CustumerRepository custumerRepository;
    private final CustumerMapper custumerMapper;
    @Override
    public Mono<Custumer> create(CustumerDto dto) {
        return custumerRepository.save(custumerMapper.toModel(dto));
    }
}
