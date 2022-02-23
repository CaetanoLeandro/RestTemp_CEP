package com.resttempcep.controller.v1;

import com.resttempcep.service.model.request.ShippingRequest;
import com.resttempcep.service.model.response.ShippingResponse;
import com.resttempcep.service.shipping.ShippingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/destinatario")
@Api("Shipping goods")
@CrossOrigin("http://localhost")
public class ShippingController {

    private final ShippingService service;

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("Save customer order")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 403, message = "Forbidden to access this shipping order"),
            @ApiResponse(code = 201, message = "Shipping order created with success")
    })
    public ShippingResponse save(@RequestBody @Valid ShippingRequest shippingRequest) {
        return service.save(shippingRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    @ApiOperation("Update customer order")
    public ShippingResponse update(@RequestBody @Valid ShippingRequest shippingRequest, @PathVariable String id) {
        return service.update(shippingRequest, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @ApiOperation("Find customer order")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Succefully retrieved list"),
            @ApiResponse(code = 401, message = "Not Authorized to view this shipping order"),
            @ApiResponse(code = 403, message = "Forbiddden to acess this shipping order"),
            @ApiResponse(code = 404, message = "The shipping order you requested was not found"),
            @ApiResponse(code = 204, message = "The shipping order not exist")
    })
    public ShippingResponse findById(@PathVariable @Valid String id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    @ApiOperation("List all customer order")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Succefully retrieved list"),
            @ApiResponse(code = 401, message = "Not Authorized to view this shipping order"),
            @ApiResponse(code = 403, message = "Forbiddden to acess this shipping order"),
            @ApiResponse(code = 404, message = "The shipping order you requested was not found"),
            @ApiResponse(code = 204, message = "The shipping order not exist")
    })
    public List<ShippingResponse> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Deletecustomer order")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized to view this shipping order"),
            @ApiResponse(code = 404, message = "The shipping order you requested was not found"),
            @ApiResponse(code = 204, message = "The shipping order not exist")
    })
    public void deleteById(@PathVariable @Valid String id) {
        service.deleteById(id);
    }
}
