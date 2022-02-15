package com.example.resttempcep.service.model.response;

import com.example.resttempcep.repository.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShippingResponse {
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    private AddressEntity addressOrigin;
    private AddressEntity addressDestination;
    private TransportResponse transport;
}
