package com.example.resttempcep.service.mapper.response;

import com.example.resttempcep.repository.entity.AddressEntity;
import com.example.resttempcep.repository.entity.OrderEntity;
import com.example.resttempcep.repository.entity.TransportEntity;
import com.example.resttempcep.service.model.AddressResponse;
import com.example.resttempcep.service.model.response.ShippingResponse;
import com.example.resttempcep.service.model.response.TransportResponse;

import java.util.Optional;

public class ShippingServiceResponseMapper {

    public static ShippingResponse toShippingResponse(OrderEntity orderEntity) {
        return Optional.ofNullable(orderEntity)
                .map((OrderEntity order) -> ShippingResponse.builder()
                        .id(orderEntity.getId())
                        .nomeDestinatario(orderEntity.getNomeDestinatario())
                        .pesoEncomenda(order.getPesoEncomenda())
                        .addressDestination(orderEntity.getAddressDestination())
                        .addressOrigin(orderEntity.getAddressOrigin())
                        .transport(toTransportResponse(orderEntity.getTransport()))
                        .build()).orElse(null);

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

    public static TransportResponse toTransportResponse(TransportEntity transportEntity) {
        return Optional.ofNullable(transportEntity)
                .map((TransportEntity transport) -> TransportResponse.builder()
                        .deliverydate(transportEntity.getDeliverydate())
                        .totalShippingValue(transportEntity.getTotalShippingValue())
                        .dataQuery(transportEntity.getDataQuery())
                        .build()).orElse(null);
    }
}
