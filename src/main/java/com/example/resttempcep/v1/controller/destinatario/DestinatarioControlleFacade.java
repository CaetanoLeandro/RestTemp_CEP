package com.example.resttempcep.v1.controller.destinatario;

import com.example.resttempcep.v1.entity.Destinatario;
import com.example.resttempcep.v1.service.destinatario.DestinatarioService;
import com.example.resttempcep.v1.service.model.request.DestinatarioServiceRequest;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;
import lombok.AllArgsConstructor;
import static com.example.resttempcep.v1.service.mapper.request.DestinatarioServiceRequestMapper.toEntityDestinatario;
import static com.example.resttempcep.v1.service.mapper.response.DestinatarioServiceResponseMapper.toDestinatarioServiceResponse;

@AllArgsConstructor
public class DestinatarioControlleFacade {

    private final DestinatarioService service;

    public DestinatarioServiceResponse save(DestinatarioServiceRequest destinatarioServiceRequest) {
        Destinatario destinatario = toEntityDestinatario(destinatarioServiceRequest);
        return toDestinatarioServiceResponse(service.save(destinatario));
    }

}
