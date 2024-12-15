package com.raspay.wsraspayapi.controller;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.dto.PaymentDto;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Payment;
import com.raspay.wsraspayapi.service.CustumerService;
import com.raspay.wsraspayapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
  @PostMapping
    public ResponseEntity<Mono<Payment>> process(@RequestBody PaymentDto dto){
      return ResponseEntity.status(HttpStatus.OK).body(paymentService.process(dto));
  }
}
