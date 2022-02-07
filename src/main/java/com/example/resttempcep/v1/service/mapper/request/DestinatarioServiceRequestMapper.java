package com.example.resttempcep.v1.service.mapper.request;

import com.example.resttempcep.v1.entity.Destinatario;
import com.example.resttempcep.v1.service.model.request.DestinatarioServiceRequest;

public class DestinatarioServiceRequestMapper {

    public static Destinatario toEntityDestinatario(DestinatarioServiceRequest destinatarioServiceRequest) {
        return Destinatario.builder()
                .id(destinatarioServiceRequest.getId())
                .nomeDestinatario(destinatarioServiceRequest.getNomeDestinatario())
                .pesoEncomenda(destinatarioServiceRequest.getPesoEncomenda())
                .cepOrigem(destinatarioServiceRequest.getCepOrigem())
                .cepDestino(destinatarioServiceRequest.getCepDestino())
                .build();
    }

}
