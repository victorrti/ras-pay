package com.raspay.wsraspayapi.mapper;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.dto.OrderDto;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface OrderMapper {
    @Mapping(target = "originalPrice",ignore = true)
    @Mapping(target = "dtRegisterOrder",ignore = true)
    @Mapping(target = "productId",ignore = true)
    @Mapping(target="id", ignore = true)
    Order toModel(OrderDto dto);
}
