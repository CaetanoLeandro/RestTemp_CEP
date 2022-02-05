package com.example.resttempcep.v1.restTemplate;

import com.example.resttempcep.v1.entity.CepEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class ConsumerApi {

    private RestTemplate restTemplate;

    public CepEntity findCep(String cep) {
        String uri = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(uri, CepEntity.class);
    }
}
