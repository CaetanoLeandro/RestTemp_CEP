package com.example.resttempcep.v1.controller.mapper.request;


import com.example.resttempcep.v1.controller.model.request.DestinatarioControllerRequest;
import com.example.resttempcep.v1.entity.Destinatario;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;

public class DestinatarioControllerRequestMapper {

    public static Destinatario toEntityDestinatario (DestinatarioControllerRequest destinatarioControllerRequest) {
        return DestinatarioServiceResponse.builder()
                .id(destinatarioControllerRequest.getId())
                .nomeDestinatario(destinatarioControllerRequest.getNomeDestinatario())
                .pesoEncomenda(destinatarioControllerRequest.getPesoEncomenda())
                .cepOrigem(destinatarioControllerRequest.getCepOrigem())
                .cepDestino(destinatarioControllerRequest.getCepDestino())
                .build();
    }

}
