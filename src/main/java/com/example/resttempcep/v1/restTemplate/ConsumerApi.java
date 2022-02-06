package com.example.resttempcep.v1.restTemplate;

import com.example.resttempcep.v1.entity.ApiExtEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class ConsumerApi {

    private RestTemplate restTemplate;

    public ApiExtEntity findCep(String cep) {
        String uri = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(uri, ApiExtEntity.class);
    }
}
