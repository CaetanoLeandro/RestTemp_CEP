package com.example.resttempcep.service.mapper.request;

import com.example.resttempcep.repository.entity.AddressEntity;
import com.example.resttempcep.repository.entity.AddressIntegration;
import com.example.resttempcep.repository.entity.OrderEntity;
import com.example.resttempcep.repository.entity.TransportEntity;
import com.example.resttempcep.service.model.request.ShippingRequest;
import com.example.resttempcep.service.model.request.TransportRequest;

import java.util.Optional;

public class ShippingServiceRequestMapper {

    public static OrderEntity toResponseEntity(
            ShippingRequest serviceRequest,
            AddressIntegration addressOrigin,
            AddressIntegration addressDestination, TransportRequest transportRequest) {
        return Optional.ofNullable(serviceRequest)
                .map((ShippingRequest shippingRequest) -> OrderEntity.builder()
                        .id(serviceRequest.getId())
                        .nomeDestinatario(serviceRequest.getNomeDestinatario())
                        .pesoEncomenda(serviceRequest.getPesoEncomenda())
                        .addressOrigin(toAddressEntity(addressOrigin))
                        .addressDestination(toAddressEntity(addressDestination))
                        .transport(toTransportEntity(transportRequest))
                        .build())
                .orElse(null);
    }

    public static AddressEntity toAddressEntity(AddressIntegration addressIntegration) {
        return Optional.ofNullable(addressIntegration)
                .map((AddressIntegration addIntegration) -> AddressEntity.builder()
                        .cep(addressIntegration.getCep())
                        .logradouro(addressIntegration.getLogradouro())
                        .bairro(addressIntegration.getBairro())
                        .localidade(addressIntegration.getLocalidade())
                        .uf(addressIntegration.getUf())
                        .ddd(addressIntegration.getDdd())
                        .build()).orElse(null);
    }

    public static TransportEntity toTransportEntity(TransportRequest transportRequest) {
        return Optional.ofNullable(transportRequest)
                .map((TransportRequest tprRequest) -> TransportEntity.builder()
                        .totalShippingValue(transportRequest.getTotalShippingValue())
                        .deliverydate(transportRequest.getDeliverydate())
                        .dataQuery(transportRequest.getDataQuery())
                        .build()).orElse(null);

    }
}
