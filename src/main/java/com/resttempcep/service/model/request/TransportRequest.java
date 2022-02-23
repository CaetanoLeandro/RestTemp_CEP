package com.resttempcep.service.model.request;

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
public class TransportRequest {
    private Double totalShippingValue;
    private Date deliverydate;
    private LocalDate dataQuery;
}
