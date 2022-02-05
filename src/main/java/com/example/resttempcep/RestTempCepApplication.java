package com.example.resttempcep;

import com.example.resttempcep.v1.entity.CepEntity;
import com.example.resttempcep.v1.entity.DadosTransporteEntity;
import com.example.resttempcep.v1.restTemplate.ConsumerApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@SpringBootApplication
public class RestTempCepApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTempCepApplication.class, args);

//        DadosTransporteEntity client1 = new DadosTransporteEntity();
//        client1.setNomeDestinatario();
//        client1.setCepOrigem();
//        client1.setCeDestino();
//        client1.setDdd();
//        client1.getDataConsulta();
//
//        if (){
//
//        }

    }


}
