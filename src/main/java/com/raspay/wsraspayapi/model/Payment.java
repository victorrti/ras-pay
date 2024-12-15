package com.raspay.wsraspayapi.model;

import com.raspay.wsraspayapi.enums.PaymentStatus;
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
    private PaymentStatus status;
    private LocalDateTime dtRegistredPayment;

    private String creditCardId;

    private String custumerId;

    private String orderId;



}
