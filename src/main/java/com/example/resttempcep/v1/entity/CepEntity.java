package com.example.resttempcep.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CepEntity {
    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String uf;
    private String ddd;
    private String localidade;
}
