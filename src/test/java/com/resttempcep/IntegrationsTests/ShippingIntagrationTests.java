package com.resttempcep.IntegrationsTests;

import com.resttempcep.config.ConsumerApi;
import com.resttempcep.controller.v1.ShippingController;
import com.resttempcep.repository.ShippingRepository;
import com.resttempcep.repository.entity.AddressEntity;
import com.resttempcep.repository.entity.OrderEntity;
import com.resttempcep.repository.entity.TransportEntity;
import com.resttempcep.service.model.request.ShippingRequest;
import com.resttempcep.service.model.response.ShippingResponse;
import com.resttempcep.service.model.response.TransportResponse;
import com.resttempcep.service.shipping.ShippingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@EnableWebMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ShippingIntagrationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ShippingRepository Repository;

    @InjectMocks
    ShippingController controller;

    @MockBean
    ConsumerApi consumerApi;

    private TransportResponse TransportEntity;
    private com.resttempcep.repository.entity.AddressEntity AddressEntity;
    private ShippingService service;
    private ShippingResponse response;
    private ShippingRequest request;

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
    }
    @Test
    @DisplayName("Should return the saved Shipping")
    void whenSaveShouldReturnTheUserSaved() {
        when(ShippingService.save(request)).thenReturn(response);
        var stubActual = controller.save(request);
        var stubExpected = ShippingResponse.builder()
                .id(response.getId())
                .nomeDestinatario(response.getNomeDestinatario())
                .pesoEncomenda(response.getPesoEncomenda())
                .addressOrigin(response.getAddressOrigin())
                .addressDestination(response.getAddressDestination())
                .transport(response.getTransport())
                .build();
        assertEquals(stubActual,stubExpected);
    }
}