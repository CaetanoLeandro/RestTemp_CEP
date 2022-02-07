package com.example.resttempcep.v1.service.destinatario;

import com.example.resttempcep.v1.entity.Destinatario;
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

    public DestinatarioServiceResponse save(DestinatarioServiceRequest destinatarioServiceRequest) {
        Destinatario destinatario = toEntityDestinatario(destinatarioServiceRequest);
        Destinatario save = service.save(destinatario);
        return toDestinatarioServiceResponse(save);
    }

    public DestinatarioServiceResponse findById(String id) {
        Destinatario byId = service.findById(id);
        return toDestinatarioServiceResponse(service.findById(id));
    }

    public DestinatarioServiceResponse update(DestinatarioServiceRequest destinatarioServiceRequest, String id) {
        Destinatario destinatarioId = service.findById(id);
        Destinatario destinatario = toEntityDestinatario(destinatarioServiceRequest);
        return toDestinatarioServiceResponse(service.update(destinatario, destinatarioId.getId()));
    }

    public List<DestinatarioServiceResponse> findAll() {
        return service.findAll().stream()
                .map(DestinatarioServiceResponseMapper::toDestinatarioServiceResponse)
                .toList();
    }

//    public void delete(List<String> id) {
//        service.delete(id);
//    }

}
