package com.example.resttempcep.v1.controller.mapper.response;

import com.example.resttempcep.v1.controller.model.response.DestinatarioControllerResponse;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;

public class DestinatarioControllerResponseMapper {

    public static DestinatarioControllerResponse toControllerResponse(DestinatarioServiceResponse destinatarioServiceResponse) {
        return DestinatarioControllerResponse.builder()
                .id(destinatarioServiceResponse.getId())
                .nomeDestinatario(destinatarioServiceResponse.getNomeDestinatario())
                .pesoEncomenda(destinatarioServiceResponse.getPesoEncomenda())
                .cepOrigem(destinatarioServiceResponse.getCepOrigem())
                .cepDestino(destinatarioServiceResponse.getCepDestino())
                .build();
    }
}
