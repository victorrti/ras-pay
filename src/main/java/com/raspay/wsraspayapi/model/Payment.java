package com.raspay.wsraspayapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    @Id
    private String id;
    private String status;
    private LocalDateTime dtRegistredPayment;
    @DBRef
    private CreditCard creditCard;
    @DBRef
    private Custumer custumer;
    @DBRef
    private Order order;



}
