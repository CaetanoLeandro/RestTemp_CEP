package com.example.resttempcep;

import com.example.resttempcep.service.model.request.ShippingRequest;
import com.example.resttempcep.service.shipping.ShippingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
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
class ShippingControllerTest {

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
    void deleteByIdNoContent() throws Exception { // 204
        mockMvc.perform(delete("/api/v1/destinatario/20"))
                .andExpect(status().isNoContent());
    }
    void deleteByIdBadRequest() throws Exception { // 400
        mockMvc.perform(delete("/api/v1/destinatario/1"))
                .andExpect(status().isBadRequest());
    }

    void findAllIsOk() throws Exception { //200
        mockMvc.perform(get("/api/v1/destinatario/0"))
                .andExpect(status().isOk());
    }

    void findByIdIsOk() throws Exception { //200
        mockMvc.perform(get("/api/v1/destinatario/5"))
                .andExpect(status().isOk());
    }

    void findByIdBadRequest() throws Exception { //200
        mockMvc.perform(get("/api/v1/destinatario/5"))
                .andExpect(status().isBadRequest());
    }
}