package com.example.resttempcep.v1.service;

import com.example.resttempcep.v1.entity.CepEntity;
import com.example.resttempcep.v1.restTemplate.ConsumerApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CepService {

    private final ConsumerApi consumerApi;

    public CepEntity getCep(String cep){
        return consumerApi.findCep(cep);
    }
}


