package com.example.resttempcep.IntegrationsTests;


import com.example.resttempcep.config.ConsumerApi;
import com.example.resttempcep.repository.ShippingRepository;
import com.example.resttempcep.repository.entity.AddressEntity;
import com.example.resttempcep.repository.entity.OrderEntity;
import com.example.resttempcep.repository.entity.TransportEntity;
import com.example.resttempcep.service.model.request.ShippingRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@EnableWebMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ShippingIntagrationTests {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    ShippingRepository shippingRepository;

    @MockBean
    ConsumerApi consumerApi;

    @Test
    void postOK() throws Exception { // 201
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .cepOrigem("33333333")
                .cepDestino("77777777")
                .build();

        OrderEntity orderEntity = OrderEntity.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .addressOrigin(new AddressEntity("33333333", "Av X", "Centro", "RS", "51", "Porto Alegre"))
                .addressDestination(new AddressEntity("77777777", "Av y", "Centro", "RS", "51", "Canoas"))
                .transport(new TransportEntity(55.33, Date.from(Instant.now()), LocalDate.of(2022, 2, 11)))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(shippingRepository.save(orderEntity)).thenReturn(orderEntity);
        mockMvc.perform(put("http://localhost:8080/api/v1/destinatario")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void postBadRequest() throws Exception {
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .cepOrigem("33333333")
                .cepDestino("77777777")
                .build();

        OrderEntity orderEntity = OrderEntity.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(null)
                .addressOrigin(new AddressEntity("33333333", "Av X", "Centro", "RS", "51", "Porto Alegre"))
                .addressDestination(new AddressEntity("77777777", "Av y", "Centro", "RS", "51", "Canoas"))
                .transport(new TransportEntity(55.33, Date.from(Instant.now()), LocalDate.of(2022, 2, 11)))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(shippingRepository.save(orderEntity)).thenReturn(orderEntity);
        mockMvc.perform(put("http://localhost:8080/api/v1/destinatario")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void patchOK() throws Exception { // 201
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .cepOrigem("33333333")
                .cepDestino("77777777")
                .build();

        OrderEntity orderEntity = OrderEntity.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .addressOrigin(new AddressEntity("33333333", "Av X", "Centro", "RS", "51", "Porto Alegre"))
                .addressDestination(new AddressEntity("77777777", "Av y", "Centro", "RS", "51", "Canoas"))
                .transport(new TransportEntity(55.33, Date.from(Instant.now()), LocalDate.of(2022, 2, 11)))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(shippingRepository.findById("xxxx")).thenReturn(Optional.of(orderEntity));
        Mockito.when(ShippingRepository.save(orderEntity)).thenReturn(orderEntity);
        mockMvc.perform(put("http://localhost:8080/api/v1/destinatario")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void patchBadRequest() throws Exception { // 201
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .cepOrigem("33333333")
                .cepDestino("77777777")
                .build();

        OrderEntity orderEntity = OrderEntity.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .addressOrigin(new AddressEntity("33333333", "Av X", "Centro", "RS", "51", "Porto Alegre"))
                .addressDestination(new AddressEntity("77777777", "Av y", "Centro", "RS", "51", "Canoas"))
                .transport(new TransportEntity(55.33, Date.from(Instant.now()), LocalDate.of(2022, 2, 11)))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(shippingRepository.findById("xxxx")).thenReturn(Optional.of(orderEntity));
        Mockito.when(ShippingRepository.save(orderEntity)).thenReturn(orderEntity);
        mockMvc.perform(put("http://localhost:8080/api/v1/destinatario")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void getAllOk() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/destinatario"))
                .andExpect(status().isOk());
    }

    void getAllNotFound() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/destinatario"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getByIdOk() throws Exception {
        OrderEntity orderEntity = OrderEntity.builder()
                .id("123")
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .addressOrigin(new AddressEntity("33333333", "Av X", "Centro", "RS", "51", "Porto Alegre"))
                .addressDestination(new AddressEntity("77777777", "Av y", "Centro", "RS", "51", "Canoas"))
                .transport(new TransportEntity(55.33, Date.from(Instant.now()), LocalDate.of(2022, 2, 11)))
                .build();

        Optional < OrderEntity > orderentity = Optional.of(new OrderEntity("123","Leandro", 15.78),
                               new AddressEntity("33333333", "Av X", "Centro", "RS", "51", "Porto Alegre"),
                               new AddressEntity("77777777", "Av Y", "Centro", "RS", "51", "Canoas"),
                               new TransportEntity( 55.33, Date.from(Instant.now()), LocalDate.of(2022, 2, 11)));

        Mockito.when(ShippingRepository.findById("xxxxxx")).thenReturn(Optional.ofNullable(orderEntity));
        mockMvc.perform(get("http://localhost:8080/api/v1/destinatario"))

                .andExpect(status().isOk());
    }

    @Test
    void getByIdNotFound() throws Exception {
        Mockito.when(ShippingRepository.findById("xxxxxx")).thenReturn(Optional.empty());
        mockMvc.perform(get("http://localhost:8080/api/v1/destinatario"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteObjNoContent() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/api/v1/destinatario"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteObj() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/api/v1/destinatario"))
                .andExpect(status().isNoContent());
    }
}