package com.example.resttempcep.v1.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DestinatarioServiceRequest {
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    private String cepOrigem;
    private String cepDestino;
}
