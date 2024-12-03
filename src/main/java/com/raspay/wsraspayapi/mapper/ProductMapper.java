package com.raspay.wsraspayapi.mapper;

import com.raspay.wsraspayapi.dto.ProductDto;
import com.raspay.wsraspayapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface ProductMapper {
    @Mapping(target="id", ignore = true)
    @Mapping(target = "dtCriation",ignore = true)
    Product toModel(ProductDto dto);
}
