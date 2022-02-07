package com.example.resttempcep.v1.controller.transporte;


import com.example.resttempcep.v1.entity.Cep;
import com.example.resttempcep.v1.entity.Transporte;
import com.example.resttempcep.v1.service.transporte.TransporteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class TransporteController {

    private final TransporteService service;

    @PostMapping //TODO -> Ajustar POST
    @ResponseStatus(CREATED)
    public Transporte save(@RequestBody @Valid Transporte transporte) {
        return service.save(transporte);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    public Transporte update(@RequestBody @Valid Transporte transporte, @PathVariable String id) {
        return service.update(transporte, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Transporte findById(@PathVariable @Valid String id) {
        return service.findById(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(NO_CONTENT)
    public void delete(@RequestParam(required = false) List<String> id) {
        service.delete(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(OK)
    public List<Transporte> findAll() {
        return service.findAll();
    }

    @GetMapping("/cep/{cep}")
    public Cep findCep(@PathVariable @Valid String cep){
        return service.getCep(cep);
    }
}