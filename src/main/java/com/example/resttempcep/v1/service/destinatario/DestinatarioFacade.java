package com.example.resttempcep.v1.service.destinatario;

import com.example.resttempcep.v1.entity.DestinatarioEntity;
import com.example.resttempcep.v1.service.mapper.response.DestinatarioServiceResponseMapper;
import com.example.resttempcep.v1.service.model.request.DestinatarioServiceRequest;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.example.resttempcep.v1.service.mapper.request.DestinatarioServiceRequestMapper.toEntityDestinatario;
import static com.example.resttempcep.v1.service.mapper.response.DestinatarioServiceResponseMapper.toDestinatarioServiceResponse;

@AllArgsConstructor
@Component
public class DestinatarioFacade {

    private final DestinatarioService service;

    public DestinatarioServiceResponse save(DestinatarioServiceRequest serviceRequest) {
        DestinatarioEntity save = service.save(toEntityDestinatario(serviceRequest));
        return toDestinatarioServiceResponse(save);
    }

    public DestinatarioServiceResponse update(DestinatarioServiceRequest destinatarioServiceRequest, String id) {
        DestinatarioEntity destinatarioEntityId = service.findById(id);
        DestinatarioEntity destinatarioEntity = toEntityDestinatario(destinatarioServiceRequest);
        return toDestinatarioServiceResponse(service.update(destinatarioEntity, destinatarioEntityId.getId()));
    }

    public DestinatarioServiceResponse findById(String id) {
        return toDestinatarioServiceResponse(service.findById(id));
    }

    public List<DestinatarioServiceResponse> findAll() {
        return service.findAll().stream()
                .map(DestinatarioServiceResponseMapper::toDestinatarioServiceResponse)
                .toList();
    }

    public void delete(String id) {
        service.deleteById(id);
    }

}
