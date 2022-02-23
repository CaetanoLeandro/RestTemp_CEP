package com.resttempcep.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShippingRequest {
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    private String cepOrigem;
    private String cepDestino;
}
