package com.raspay.wsraspayapi.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("creditCards")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditCard {
    @Id
    private String id;
    @NotBlank
    private String number;
    @NotBlank
    private String cvv;
    private int year;
    private String documentNumber;
    private int installments;

    private String custumerId;

}
