package com.example.resttempcep.v1.controller.destinatario;

import com.example.resttempcep.v1.entity.Destinatario;
import com.example.resttempcep.v1.service.destinatario.DestinatarioService;
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
    public Destinatario save(@RequestBody @Valid Destinatario destinatario) {
        return facade.save(destinatario);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    public Destinatario update(@RequestBody @Valid Destinatario destinatario, @PathVariable String id) {
        return facade.update(destinatario, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Destinatario findById(@PathVariable @Valid String id) {
        return facade.findById(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(NO_CONTENT)
    public void delete(@RequestParam(required = false) List<String> id) {
        facade.delete(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<Destinatario> findAll() {
        return facade.findAll();
    }

}

