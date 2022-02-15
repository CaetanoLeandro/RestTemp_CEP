package com.example.resttempcep.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransportResponse {
    private Double totalShippingValue;
    private Date deliverydate;
    private LocalDate dataQuery;
}
