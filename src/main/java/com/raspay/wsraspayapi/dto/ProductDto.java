package com.raspay.wsraspayapi.dto;

import java.math.BigDecimal;

public record ProductDto(
        String acronym,
        String name,
        BigDecimal currentPrice
) {

}
