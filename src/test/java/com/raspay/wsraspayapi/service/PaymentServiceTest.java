package com.raspay.wsraspayapi.service;

import com.raspay.wsraspayapi.dto.CreditCardDto;
import com.raspay.wsraspayapi.dto.PaymentDto;
import com.raspay.wsraspayapi.enums.PaymentStatus;
import com.raspay.wsraspayapi.model.CreditCard;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Order;
import com.raspay.wsraspayapi.model.Payment;
import com.raspay.wsraspayapi.repository.PaymentRepository;
import com.raspay.wsraspayapi.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class PaymentServiceTest {
    @Mock
    private CustumerService customerService;

    @Mock
    private OrderService orderService;

    @Mock
    private CreditCardService creditCardService;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;


    @Test
    void shouldApprovePaymentWhenCreditCardIsFoundAndCustomerIdIsCorrect() {
        Custumer customer = getCustomer();
        Order order = getOrder(customer.getId());
        CreditCardDto creditCardDto = new CreditCardDto(
                "123",
                customer.getCpf(),
                12,
                "0123456789012345",
                28,
                1
        );

        PaymentDto paymentDto = new PaymentDto(
                creditCardDto,
                customer.getId(),
                order.getId()
        );

        Mockito.when(customerService.findById(paymentDto.custumerId()))
                .thenReturn(Mono.just(customer));

        Mockito.when(orderService.findById(paymentDto.orderId()))
                .thenReturn(Mono.just(order));

        CreditCard creditCard = new CreditCard();
        creditCard.setId("123456");
        creditCard.setDocumentNumber("74949192019");
        creditCard.setCustumerId(customer.getId());

        Mockito.when(creditCardService.findByNumber(creditCardDto.number()))
                .thenReturn(Mono.just(creditCard));

        Payment paymentSaved = new Payment();
        paymentSaved.setStatus(PaymentStatus.APROVED);

        Mockito.when(paymentRepository.save(Mockito.any())).thenReturn(Mono.just(paymentSaved));

        Mono<Payment> paymentMono = paymentService.process(paymentDto);

        StepVerifier.create(paymentMono)
                .expectNextMatches(payment -> payment.getStatus().equals(PaymentStatus.APROVED))
                .verifyComplete();

        Mockito.verify(customerService, Mockito.times(1)).findById(paymentDto.custumerId());
        Mockito.verify(orderService, Mockito.times(1)).findById(paymentDto.orderId());
        Mockito.verify(creditCardService, Mockito.times(1)).findByNumber(paymentDto.creditCard().number());
        Mockito.verify(creditCardService, Mockito.times(0)).create(Mockito.any(),Mockito.any());
        Mockito.verify(paymentRepository, Mockito.times(1)).save(Mockito.any());
    }

    private Custumer getCustomer() {
        Custumer customer = new Custumer();
        customer.setId("123456");
        customer.setCpf("40750233036");
        return customer;
    }

    private Order getOrder(String customerId) {
        Order order = new Order();
        order.setId("123456");
        order.setCustumerId("123456");
        return order;
    }
}
