package com.raspay.wsraspayapi.service.impl;

import com.raspay.wsraspayapi.dto.PaymentDto;
import com.raspay.wsraspayapi.enums.PaymentStatus;
import com.raspay.wsraspayapi.model.CreditCard;
import com.raspay.wsraspayapi.model.Custumer;
import com.raspay.wsraspayapi.model.Order;
import com.raspay.wsraspayapi.model.Payment;
import com.raspay.wsraspayapi.repository.PaymentRepository;
import com.raspay.wsraspayapi.service.CreditCardService;
import com.raspay.wsraspayapi.service.CustumerService;
import com.raspay.wsraspayapi.service.OrderService;
import com.raspay.wsraspayapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final CustumerService custumerService;
    private final CreditCardService creditCardService;
    private final OrderService orderService;


    @Override
    public Mono<Payment> process(PaymentDto dto) {

        Mono<Custumer> custumerMono = custumerService.findById(dto.custumerId());
        Mono<Order> orderMono  = orderService.findById(dto.orderId());
        return Mono.zip(custumerMono,orderMono,(custumer,order) ->
            creditCardService.findByNumber(dto.creditCard().number())
                    .flatMap(creditCard ->
                         autoridPayment(custumer, order, creditCard)
                    )
                    .onErrorResume(error ->
                        creditCardService.create(dto.creditCard(),custumer)
                                .flatMap(creditCard ->
                                     authorizedPaymentWithNewCreditCard(custumer, order, creditCard)
                                )
                    )
        ).flatMap(payment -> payment);

    }
    private Mono<Payment> authorizedPaymentWithNewCreditCard(Custumer custumer, Order order, CreditCard creditCard) {
        return savePayment(custumer, order, creditCard,PaymentStatus.APROVED);
    }

    private Mono<Payment> savePayment(Custumer custumer, Order order, CreditCard creditCard,PaymentStatus status) {
        var payemntBuilder = Payment.builder();
        payemntBuilder.dtRegistredPayment(LocalDateTime.now())
                .order(order)
                .custumer(custumer)
                .status(status)
                .creditCard(creditCard);
        return paymentRepository.save(payemntBuilder.build());
    }

    private Mono<Payment> autoridPayment(Custumer custumer, Order order, CreditCard creditCard) {
        if(creditCard.getCustumer().getId().equals(order.getId())
                || creditCard.getDocumentNumber().equals(custumer.getCpf())){
            return savePayment(custumer,order,creditCard,PaymentStatus.APROVED);

        }else{
            return savePayment(custumer,order,creditCard,PaymentStatus.DISAPROVED);
        }

    }
}
