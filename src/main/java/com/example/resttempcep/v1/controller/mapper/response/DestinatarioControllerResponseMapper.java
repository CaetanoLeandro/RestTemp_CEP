package com.example.resttempcep.v1.controller.mapper.response;

import com.example.resttempcep.v1.controller.model.response.DestinatarioControllerResponse;
import com.example.resttempcep.v1.entity.CepIntegration;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;

import java.util.Optional;

import static com.example.resttempcep.v1.service.mapper.response.DestinatarioServiceResponseMapper.toDestinatarioEntity;

public class DestinatarioControllerResponseMapper {

    public static DestinatarioControllerResponse
    toControllerResponse(DestinatarioServiceResponse destinatarioServiceResponse, CepIntegration cep) {
        return Optional.ofNullable(destinatarioServiceResponse)
                .map(destinatarioServiceResponse1 -> DestinatarioControllerResponse.builder()
                        .id(destinatarioServiceResponse.getId())
                        .nomeDestinatario(destinatarioServiceResponse.getNomeDestinatario())
                        .pesoEncomenda(destinatarioServiceResponse.getPesoEncomenda())
                        .cepOrigem(toDestinatarioEntity(cep))
                        .cepDestino(toDestinatarioEntity(cep))
                        .build()).orElse(null);
    }
}
