package com.example.resttempcep.v1.controller.destinatario;

import com.example.resttempcep.v1.controller.model.request.DestinatarioControllerRequest;
import com.example.resttempcep.v1.controller.model.response.DestinatarioControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/destinatario")
public class DestinatarioController {

    private final DestinatarioControlleFacade facade;

    @PostMapping
    @ResponseStatus(CREATED)
    public DestinatarioControllerResponse save(@RequestBody @Valid DestinatarioControllerRequest destinatarioRequest) {
        return facade.save(destinatarioRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    public DestinatarioControllerResponse update(@RequestBody @Valid DestinatarioControllerRequest destinatarioRequest,
                                                 @PathVariable String id) {
        return facade.update(destinatarioRequest, id);

    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public DestinatarioControllerResponse findById(@PathVariable @Valid String id) {
        return facade.findById(id);
    }

//    @DeleteMapping("/")
//    @ResponseStatus(NO_CONTENT)
//    public void delete(@RequestParam(required = false) List<String> id) {
//        facade.delete(id);
//    }

    @GetMapping
    @ResponseStatus(OK)
    public List<DestinatarioControllerResponse> findAll() {
        return facade.findAll();
    }

}
