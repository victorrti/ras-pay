package com.raspay.wsraspayapi.exception.handler;


import com.raspay.wsraspayapi.dto.exception.ErrorResponseDto;
import com.raspay.wsraspayapi.exception.BadRequestException;
import com.raspay.wsraspayapi.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ResourceHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Mono<ErrorResponseDto>> notFoundException(NotFoundException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mono.just(errorResponseDto));

    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Mono<ErrorResponseDto>> badRequestException(BadRequestException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Mono.just(errorResponseDto));
    }
}
