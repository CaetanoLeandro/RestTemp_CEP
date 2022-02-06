package com.example.resttempcep.v1.controller;


import com.example.resttempcep.v1.entity.ApiExtEntity;
import com.example.resttempcep.v1.entity.CepEntity;
import com.example.resttempcep.v1.service.CepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final CepService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public CepEntity save(@RequestBody @Valid CepEntity cepEntity) {
        return service.save(cepEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    public CepEntity update(@RequestBody @Valid CepEntity cepEntity, @PathVariable String id) {
        return service.update(cepEntity, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CepEntity findById(@PathVariable @Valid String id) {
        return service.findById(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(NO_CONTENT)
    public void delete(@RequestParam(required = false) List<String> id) {
        service.delete(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(OK)
    public List<CepEntity> findAll() {
        return service.findAll();
    }
    @GetMapping("/cep/{cep}")
    public ApiExtEntity findCep(@PathVariable @Valid String cep){
        return service.getCep(cep);

    }
}