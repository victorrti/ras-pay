package com.raspay.wsraspayapi.mapper;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.dto.ProductDto;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface CustumerMapper {
    @Mapping(target="id", ignore = true)
    Custumer toModel(CustumerDto dto);
}
