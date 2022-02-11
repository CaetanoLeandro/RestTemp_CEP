package com.example.resttempcep.v1.service.shipping;

import com.example.resttempcep.v1.config.ConsumerApi;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.ShippingRepository;
import com.example.resttempcep.v1.repository.entity.AddressIntegration;
import com.example.resttempcep.v1.repository.entity.OrderEntity;
import com.example.resttempcep.v1.service.mapper.response.ShippingServiceResponseMapper;
import com.example.resttempcep.v1.service.model.request.ShippingRequest;
import com.example.resttempcep.v1.service.model.response.ShippingResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static com.example.resttempcep.v1.service.mapper.request.ShippingServiceRequestMapper.toResponseEntity;
import static com.example.resttempcep.v1.service.mapper.response.ShippingServiceResponseMapper.toShippingResponse;

@AllArgsConstructor
@Service
public class ShippingService {

    private final ShippingRepository repository;
    private final ConsumerApi consumerApi;

    public ShippingResponse save(ShippingRequest shippingRequest) {
        AddressIntegration cepOrigin = consumerApi.findAddressIntegration(shippingRequest.getCepOrigem());
        AddressIntegration cepDestino = consumerApi.findAddressIntegration(shippingRequest.getCepDestino());
        OrderEntity orderEntity = toResponseEntity(shippingRequest, cepOrigin, cepDestino);
        OrderEntity save = repository.save(orderEntity);
        return toShippingResponse(save);
    }

    public ShippingResponse update(ShippingRequest shippingRequest, String id) {
        AddressIntegration cepOrigin = consumerApi.findAddressIntegration(shippingRequest.getCepOrigem());
        AddressIntegration cepDestino = consumerApi.findAddressIntegration(shippingRequest.getCepDestino());
        OrderEntity orderEntity = toResponseEntity(shippingRequest, cepOrigin, cepDestino);
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


    public void calculateShipping(AddressIntegration addressOrigin, AddressIntegration addressDestination) {

        final Double weightValue = 1.00D;
        Double totalShippingValue;
        Date date;

        // getUf() is AddressIntegration
        boolean isSameUf = Boolean.parseBoolean(String.valueOf(addressOrigin.getCep().substring(0, 1)
                .equals(addressDestination.getCep().substring(0, 1))));

        // getDdd() is AddressIntegration
        boolean isSameDdd = addressOrigin.getDdd().equals(addressDestination.getDdd());

        if (isSameUf) {
            date = shippingForecast(1); // * Prazo de entrega (dias)
            totalShippingValue = 0.50D * weightValue; // 50% desconto
        } else if (isSameUf && isSameDdd) {
            date = shippingForecast(3); // *
            totalShippingValue = 0.25D * weightValue; // 75% desconto
        } else {
            date = shippingForecast(10);// *
            totalShippingValue = weightValue;
        }

    }

    private Date shippingForecast(final Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

}
