package com.example.resttempcep.v1.controller.model.response;

import com.example.resttempcep.v1.entity.CepEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DestinatarioControllerResponse {
        private String id;
        private String nomeDestinatario;
        private Double pesoEncomenda;
        private CepEntity cepOrigem;
        private CepEntity cepDestino;
}
