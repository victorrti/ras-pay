package com.raspay.wsraspayapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raspay.wsraspayapi.dto.CustumerDto;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.service.CustumerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
@WebFluxTest(CustumerController.class)
class CustumerControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private CustumerService custumerService;

     /* @Test
    void shouldReturnOnlyOneCustumerFilteredByCPF(){
        Custumer customer = new Custumer();
        customer.setId("123456");
        customer.setCpf("00000000000");
        Mockito.when(custumerService.findAll('','',"00000000000",0,1,"asc"))
        .thenReturn(Flux.just(custumer))

        webTestClient.get().uri(uriBuilder ->
        uriBuilder
                .path("/v1/cutumer")
                .queryParams("pageNumber",0)
                .queryParams("pageSize",1)
                .queryParams("cpf","00000000000")
                .build())
                .accept(MediaType.APPLICATION.JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualsTo(ObjectMapper.writeValueAsString(List.of(custumer)));

    }*/

    @Test
    void shouldSaveNewCustumer() throws JsonProcessingException {

        Custumer custumerSved = new Custumer();
        custumerSved.setId("123");
        custumerSved.setFirstName("teste");
        custumerSved.setLastName("teste");
        custumerSved.setCpf("40750233036");
        custumerSved.setEmail("teste@teste.com");
        CustumerDto custumerDto = new CustumerDto(custumerSved.getEmail(),custumerSved.getFirstName(),custumerSved.getLastName(),custumerSved.getCpf());
        Mockito.when(custumerService.create(custumerDto).thenReturn(custumerSved));
        webTestClient.post().uri("/v1/custumer")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(custumerDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(String.class)
                .isEqualTo(objectMapper.writeValueAsString(custumerSved));

    }



}