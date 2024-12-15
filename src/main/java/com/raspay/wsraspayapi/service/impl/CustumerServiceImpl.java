package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.exception.NotFoundException;
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
    public Mono<Custumer> findById(String id) {
        return custumerRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Custumer not found")));
    }

    @Override
    public Mono<Custumer> create(CustumerDto dto) {
        return custumerRepository.findByEmail(dto.email())
                .flatMap(custumer ->{
                    custumer.setFirstName(dto.firstName());
                    custumer.setLastName(dto.lastName());
                    return custumerRepository.save(custumer);
                } ).switchIfEmpty(
                        custumerRepository.save(custumerMapper.toModel(dto))

                );


    }
}
