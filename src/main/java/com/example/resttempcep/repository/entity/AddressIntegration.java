package com.example.resttempcep.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressIntegration {
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;
    private String ddd;
    private String localidade;
}
