package com.raspay.wsraspayapi.mapper;

import com.raspay.wsraspayapi.dto.CreditCardDto;
import com.raspay.wsraspayapi.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditCardMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "custumer", ignore = true)
    CreditCard toModel(CreditCardDto dto);
}
