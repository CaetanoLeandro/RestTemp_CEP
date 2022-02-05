package com.example.resttempcep.v1.controller;


import com.example.resttempcep.v1.entity.CepEntity;
import com.example.resttempcep.v1.service.CepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final CepService service;

    @GetMapping("/cep/{cep}")
    public CepEntity findCep(@PathVariable @Valid String cep){
        return service.getCep(cep);

    }
}