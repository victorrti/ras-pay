package com.raspay.wsraspayapi.mapper;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.dto.OrderDto;
import com.raspay.wsraspayapi.model.Custumer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface OrderMapper {
    @Mapping(target="id", ignore = true)
    Custumer toModel(OrderDto dto);
}
