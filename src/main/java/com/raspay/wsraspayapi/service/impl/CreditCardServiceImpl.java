package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.CreditCardDto;
import com.raspay.wsraspayapi.exception.BadRequestException;
import com.raspay.wsraspayapi.exception.NotFoundException;
import com.raspay.wsraspayapi.mapper.CreditCardMapper;
import com.raspay.wsraspayapi.model.CreditCard;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.repository.CreditCardRepository;
import com.raspay.wsraspayapi.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;
    @Override
    public Mono<CreditCard> findByNumber(String number) {
        return creditCardRepository.findByNumber(number).switchIfEmpty(
                Mono.error(new NotFoundException("Credit card not found"))
        );
    }

    @Override
    public Mono<CreditCard> create(CreditCardDto creditCardDto, Custumer custumer) {
        CreditCard creditCard = creditCardMapper.toModel(creditCardDto);
        creditCard.setCustumerId(custumer.getId());
        return creditCardRepository.save(creditCard);
    }
}
