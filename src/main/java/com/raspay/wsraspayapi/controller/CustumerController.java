package com.raspay.wsraspayapi.controller;

import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.service.CustumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/custumer")
@RequiredArgsConstructor
public class CustumerController {
    private final CustumerService custumerService;
  @PostMapping
    public ResponseEntity<Mono<Void>> create(@RequestBody CustumerDto dto){

      return ResponseEntity.status(HttpStatus.CREATED).body(custumerService.create(dto).then());
  }
}
