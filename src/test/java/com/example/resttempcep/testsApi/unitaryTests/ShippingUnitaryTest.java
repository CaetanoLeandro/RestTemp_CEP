package com.example.resttempcep.testsApi.unitaryTests;

import com.example.resttempcep.service.model.request.ShippingRequest;
import com.example.resttempcep.service.shipping.ShippingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@EnableWebMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ShippingUnitaryTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ShippingService shippingService;

    @Test
    void save() throws Exception { // 201
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Leandro")
                .pesoEncomenda(15.78)
                .cepOrigem("33333333")
                .cepDestino("77777777")
                .build();
        mockMvc.perform(put("/api/v1/destinatario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateNoContent() throws Exception { // 400
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Caetano")
                .pesoEncomenda(11.33)
                .cepOrigem("44444444")
                .cepDestino("88888888")
                .build();
        mockMvc.perform(put("/api/v1/destinatario/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isNoContent());
    }

    @Test
    void updateBadRequest() throws Exception { // 400
        ShippingRequest shippingRequest = ShippingRequest.builder()
                .nomeDestinatario("Caetano")
                .pesoEncomenda(11.33)
                .cepOrigem("44444444")
                .cepDestino("88888888")
                .build();
        mockMvc.perform(put("/api/v1/destinatario/id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shippingRequest)))
                .andExpect(status().isBadRequest());
    }
    @Test
    void deleteByIdNoContent() throws Exception { // 204
        mockMvc.perform(delete("/api/v1/destinatario/id"))
                .andExpect(status().isNoContent());
    }
    @Test
    void deleteByIdBadRequest() throws Exception { // 400
        mockMvc.perform(delete("/api/v1/destinatario/i2d"))
                .andExpect(status().isBadRequest());
    }
    @Test
    void findAllIsOk() throws Exception { //200
        mockMvc.perform(get("/api/v1/destinatario/id"))
                .andExpect(status().isOk());
    }
    @Test
    void findByIdIsOk() throws Exception { //200
        mockMvc.perform(get("/api/v1/destinatario/id"))
                .andExpect(status().isOk());
    }
    @Test
    void findByIdBadRequest() throws Exception { //200
        mockMvc.perform(get("/api/v1/destinatario/i2d"))
                .andExpect(status().isBadRequest());
    }
}