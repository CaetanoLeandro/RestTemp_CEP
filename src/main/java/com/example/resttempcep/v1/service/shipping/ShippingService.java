package com.example.resttempcep.v1.service.shipping;

import com.example.resttempcep.v1.config.ConsumerApi;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.ShippingRepository;
import com.example.resttempcep.v1.repository.entity.AddressIntegration;
import com.example.resttempcep.v1.repository.entity.OrderEntity;
import com.example.resttempcep.v1.service.mapper.response.ShippingServiceResponseMapper;
import com.example.resttempcep.v1.service.model.request.ShippingRequest;
import com.example.resttempcep.v1.service.model.request.TransportRequest;
import com.example.resttempcep.v1.service.model.response.ShippingResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static com.example.resttempcep.v1.service.mapper.request.ShippingServiceRequestMapper.toResponseEntity;
import static com.example.resttempcep.v1.service.mapper.response.ShippingServiceResponseMapper.toShippingResponse;

@AllArgsConstructor
@Service
public class ShippingService {

    private ShippingRepository repository;
    private ConsumerApi consumerApi;

    public ShippingResponse save(ShippingRequest shippingRequest) {
        AddressIntegration CepOrigem = consumerApi.findAddressIntegration(shippingRequest.getCepOrigem());
        AddressIntegration CepDestino = consumerApi.findAddressIntegration(shippingRequest.getCepDestino());
        TransportRequest calculationTransport = toCalculationShipping(CepOrigem, CepDestino, shippingRequest);
        OrderEntity orderEntity = toResponseEntity(shippingRequest, CepOrigem, CepDestino, calculationTransport);
        OrderEntity save = repository.save(orderEntity);
        return toShippingResponse(save);
    }

    public ShippingResponse update(ShippingRequest shippingRequest, String id) {
        AddressIntegration zipOrigin = consumerApi.findAddressIntegration(shippingRequest.getCepOrigem());
        AddressIntegration zipDestination = consumerApi.findAddressIntegration(shippingRequest.getCepDestino());
        TransportRequest calculationTransport = toCalculationShipping(zipOrigin, zipDestination, shippingRequest);
        OrderEntity orderEntity = toResponseEntity(shippingRequest, zipOrigin, zipDestination, calculationTransport);
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        OrderEntity save = repository.save(orderEntity);
        return toShippingResponse(save);
    }

    public ShippingResponse findById(String id) {
        OrderEntity orderEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return toShippingResponse(orderEntity);
    }

    public List<ShippingResponse> findAll() {
        return repository.findAll().stream()
                .map(ShippingServiceResponseMapper::toShippingResponse)
                .toList();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }


    private TransportRequest toCalculationShipping(AddressIntegration addressOrigin,
                                                   AddressIntegration addressDestination, ShippingRequest shippingRequest) {

        final Double weightValue = 1.00D;
        Double totalShippingValue;
        Date deliverydate;
        Double weight = shippingRequest.getPesoEncomenda();

        // getUf() is AddressIntegration
        boolean isSameUf = Boolean.parseBoolean(String.valueOf(addressOrigin.getCep().substring(0, 1)
                .equals(addressDestination.getCep().substring(0, 1))));

        // getDdd() is AddressIntegration
        boolean isSameDdd = addressOrigin.getDdd().equals(addressDestination.getDdd());

        if (isSameUf) {
            deliverydate = shippingForecast(1); // * Prazo de entrega (dias)
            totalShippingValue = (weight * 0.50D) * weightValue; // 50% desconto
        } else if (isSameUf && isSameDdd) {
            deliverydate = shippingForecast(3); // *
            totalShippingValue = (weight * 0.25D) * weightValue; // 75% desconto
        } else {
            deliverydate = shippingForecast(10);// *
            totalShippingValue = weightValue;
        }

        return TransportRequest.builder()
                .totalShippingValue(totalShippingValue)
                .deliverydate(deliverydate)
                .dataQuery(LocalDate.now())
                .build();
    }

    private Date shippingForecast(final Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
