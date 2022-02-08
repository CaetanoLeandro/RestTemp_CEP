package com.example.resttempcep.v1.controller.mapper.request;

import com.example.resttempcep.v1.controller.model.request.DestinatarioControllerRequest;
import com.example.resttempcep.v1.service.model.request.DestinatarioServiceRequest;

import java.util.Optional;


public class DestinatarioControllerRequestMapper {

    public static DestinatarioServiceRequest toServiceRequest(DestinatarioControllerRequest destinatarioServiceRequest) {
        return Optional.ofNullable(destinatarioServiceRequest)
                .map(destinatarioControllerRequest1 -> DestinatarioServiceRequest.builder()
                .id(destinatarioServiceRequest.getId())
                .nomeDestinatario(destinatarioServiceRequest.getNomeDestinatario())
                .pesoEncomenda(destinatarioServiceRequest.getPesoEncomenda())
                .cepOrigem(destinatarioServiceRequest.getCepOrigem())
                .cepDestino(destinatarioServiceRequest.getCepDestino())
                .build()).orElse(null);
    }

}
