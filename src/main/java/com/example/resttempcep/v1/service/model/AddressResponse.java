package com.example.resttempcep.v1.service.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressResponse {
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;
    private String ddd;
    private String localidade;
}
