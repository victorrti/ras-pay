package com.raspay.wsraspayapi.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.index.Indexed;

public record CustumerDto(
       String email,
       String firstName,
       String lastName,
       String cpf
) {
}
