package com.example.resttempcep.v1.controller;


import com.example.resttempcep.v1.entity.Entity;
import com.example.resttempcep.v1.service.CepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/sigabem")
public class Controller {

    private final CepService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Entity save(@RequestBody @Valid Entity entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    public Entity update(@RequestBody @Valid Entity entity, @PathVariable String id) {
        return service.update(entity, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Entity findById(@PathVariable @Valid String id) {
        return service.findById(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(NO_CONTENT)
    public void delete(@RequestParam(required = false) List<String> id) {
        service.delete(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(OK)
    public List<Entity> findAll() {
        return service.findAll();
    }

    @GetMapping("cep/{cep}")
    public Entity findCep(@PathVariable @Valid String cep){
        return service.findById(cep);

    }
}