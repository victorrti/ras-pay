package com.raspay.wsraspayapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    @Id
    private String id;
    @DBRef
    private Custumer custumer;
    private BigDecimal originalPrice;
    private BigDecimal descount;
    private LocalDateTime dtRegisterOrder;
    @DBRef
    private Product product;
}
