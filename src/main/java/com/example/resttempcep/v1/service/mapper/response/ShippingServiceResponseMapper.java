package com.example.resttempcep.v1.service.mapper.response;

import com.example.resttempcep.v1.repository.entity.AddressEntity;
import com.example.resttempcep.v1.repository.entity.OrderEntity;
import com.example.resttempcep.v1.service.model.AddressResponse;
import com.example.resttempcep.v1.service.model.response.ShippingResponse;

import java.util.Optional;

public class ShippingServiceResponseMapper {

    public static ShippingResponse toShippingResponse(OrderEntity orderEntity) {
        return ShippingResponse.builder()
                .id(orderEntity.getId())
                .nomeDestinatario(orderEntity.getNomeDestinatario())
                .addressDestination(orderEntity.getAddressDestination())
                .addressOrigin(orderEntity.getAddressOrigin())
                .build();

    }

    public static AddressResponse toAdddressResponse(AddressEntity addressEntity) {
        return Optional.ofNullable(addressEntity)
                .map((AddressEntity address) -> AddressResponse.builder()
                        .cep(addressEntity.getCep())
                        .localidade(addressEntity.getLocalidade())
                        .bairro(addressEntity.getBairro())
                        .ddd(addressEntity.getDdd())
                        .uf(addressEntity.getUf())
                        .build()).orElse(null);
    }
}
