package com.example.resttempcep.v1.controller.destinatario;

import com.example.resttempcep.v1.controller.mapper.response.DestinatarioControllerResponseMapper;
import com.example.resttempcep.v1.controller.model.request.DestinatarioControllerRequest;
import com.example.resttempcep.v1.controller.model.response.DestinatarioControllerResponse;
import com.example.resttempcep.v1.service.destinatario.DestinatarioFacade;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.example.resttempcep.v1.controller.mapper.request.DestinatarioControllerRequestMapper.toServiceRequest;
import static com.example.resttempcep.v1.controller.mapper.response.DestinatarioControllerResponseMapper.toControllerResponse;

@AllArgsConstructor
@Component
public class DestinatarioControlleFacade {

    private final DestinatarioFacade facade;

    public DestinatarioControllerResponse save(DestinatarioControllerRequest destinatarioRequest) {
        DestinatarioServiceResponse save = facade.save(toServiceRequest(destinatarioRequest));
        return toControllerResponse(save);
    }

    public DestinatarioControllerResponse update(DestinatarioControllerRequest destinatarioRequest, String id) {
        DestinatarioServiceResponse update = facade.update(toServiceRequest(destinatarioRequest), id);
        return toControllerResponse(update);
    }

    public DestinatarioControllerResponse findById(String id){
        return toControllerResponse(facade.findById(id));
    }

    public List<DestinatarioControllerResponse> findAll() {
        return facade.findAll().stream()
                .map(DestinatarioControllerResponseMapper::toControllerResponse)
                .toList();
    }

    public void deleteById(String id) {
        facade.delete(id);
    }

}
