package com.raspay.wsraspayapi.dto;

public record PaymentDto(
        CreditCardDto creditCard,
        String custumerId,
        String orderId
) {
}
