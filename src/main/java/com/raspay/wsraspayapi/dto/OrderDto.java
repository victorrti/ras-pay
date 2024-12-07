package com.raspay.wsraspayapi.dto;

import java.math.BigDecimal;

public record OrderDto(
        String custumerId,
        BigDecimal descount,
        String productAcronym

) {

}
