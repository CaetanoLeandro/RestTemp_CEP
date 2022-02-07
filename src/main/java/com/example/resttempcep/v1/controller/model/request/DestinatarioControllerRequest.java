package com.example.resttempcep.v1.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DestinatarioControllerRequest {
        private String id;
        private String nomeDestinatario;
        private Double pesoEncomenda;
        private String cepOrigem;
        private String cepDestino;
}
