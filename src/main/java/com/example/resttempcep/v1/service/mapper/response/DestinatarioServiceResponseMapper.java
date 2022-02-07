package com.example.resttempcep.v1.service.mapper.response;

import com.example.resttempcep.v1.entity.Destinatario;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;

public class DestinatarioServiceResponseMapper {

    public static DestinatarioServiceResponse toDestinatarioServiceResponse(Destinatario destinatario) {
        return DestinatarioServiceResponse.builder()
                .id(destinatario.getId())
                .nomeDestinatario(destinatario.getNomeDestinatario())
                .pesoEncomenda(destinatario.getPesoEncomenda())
                .cepOrigem(destinatario.getCepOrigem())
                .cepDestino(destinatario.getCepDestino())
                .build();
    }

}
