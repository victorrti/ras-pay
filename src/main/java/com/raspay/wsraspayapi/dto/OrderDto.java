package com.raspay.wsraspayapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record OrderDto(
        @NotBlank
        String custumerId,
        @Min(0)
        BigDecimal descount,
        @NotBlank
        String productAcronym

) {

}
