package com.example.resttempcep.v1.controller.mapper.response;

import com.example.resttempcep.v1.entity.Destinatario;

public class DestinatarioControllerResponse {

    public static DestinatarioControllerResponse toDestinatarioContrellerResponse(Destinatario destinatario) {
        return DestinatarioControllerResponse.builder()
                .id(destinatario.getId())
                .nomeDestinatario(destinatario.getNomeDestinatario())
                .pesoEncomenda(destinatario.getPesoEncomenda())
                .cepOrigem(destinatario.getCepOrigem())
                .cepDestino(destinatario.getCepDestino())
                .build();
    }
}
