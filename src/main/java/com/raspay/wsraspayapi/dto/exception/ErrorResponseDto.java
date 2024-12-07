package com.raspay.wsraspayapi.dto.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponseDto(
        String message,
        int httpCode
) {
}
