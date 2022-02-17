package com.example.resttempcep.controller.v1;


import com.example.resttempcep.annotations.SizeCep;
import com.example.resttempcep.service.model.request.ShippingRequest;
import com.example.resttempcep.service.model.response.ShippingResponse;
import com.example.resttempcep.service.shipping.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/destinatario")
public class ShippingController {

    private final ShippingService service;

    @PostMapping
    @ResponseStatus(CREATED)
    @SizeCep
    public ShippingResponse save(@RequestBody @Valid ShippingRequest shippingRequest) {
        return service.save(shippingRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    @SizeCep
    public ShippingResponse update(@RequestBody @Valid ShippingRequest shippingRequest, @PathVariable String id) {
        return service.update(shippingRequest, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ShippingResponse findById(@PathVariable @Valid String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable @Valid String id) {
        service.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ShippingResponse> findAll() {
        return service.findAll();
    }
}
