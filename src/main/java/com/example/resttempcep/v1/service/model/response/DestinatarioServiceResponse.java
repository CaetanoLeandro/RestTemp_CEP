package com.example.resttempcep.v1.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DestinatarioServiceResponse {
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    private String cepOrigem;
    private String cepDestino;
}
