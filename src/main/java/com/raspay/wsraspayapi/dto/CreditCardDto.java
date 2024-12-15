package com.raspay.wsraspayapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record CreditCardDto(
        @Size(min =3,max = 3)
        String cvv,
        @Size(min =16, max =16)
        String documentNumber,
        @Min(1)
        @Max(12)
        int month,

        String number,
        @Min(24)
        @Max(40)
        int year,
        @Min(0)
        @Max(12)
        int installments
) {
}
