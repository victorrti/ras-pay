package com.raspay.wsraspayapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("custumer")
public class Custumer {
    @Id
    private String id;
    @Email
    @NotBlank
    private String email;
    private String firstName;
    private String lastName;
    @CPF
    @NotBlank
    @Indexed(unique = true)
    private String cpf;
}
