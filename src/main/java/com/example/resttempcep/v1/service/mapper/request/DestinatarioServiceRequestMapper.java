package com.example.resttempcep.v1.service.mapper.request;

import com.example.resttempcep.v1.entity.DestinatarioEntity;
import com.example.resttempcep.v1.service.model.request.DestinatarioServiceRequest;

import java.util.Optional;

public class DestinatarioServiceRequestMapper {

    public static DestinatarioEntity toEntityDestinatario(DestinatarioServiceRequest serviceRequest) {
        return Optional.ofNullable(serviceRequest)
                .map(destinatarioServiceRequest1 -> DestinatarioEntity.builder()
                .id(serviceRequest.getId())
                .nomeDestinatario(serviceRequest.getNomeDestinatario())
                .pesoEncomenda(serviceRequest.getPesoEncomenda())
                .cepOrigem(serviceRequest.getCepOrigem())
                .cepDestino(serviceRequest.getCepDestino())
                .build()).orElse(null);
    }

}
