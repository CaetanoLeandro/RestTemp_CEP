package com.resttempcep.config;

import com.resttempcep.repository.entity.AddressIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class ConsumerApi {

    private RestTemplate restTemplate;

    public AddressIntegration findAddressIntegration(String cep) {
       return restTemplate.getForObject("https://viacep.com.br/ws/" +
                cep + "/json/", AddressIntegration.class);
    }
}
