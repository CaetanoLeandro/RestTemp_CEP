package com.example.resttempcep.v1.service.model.response;

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
    private String id;
    private Double valorTotalFrete;
    private Date dataPrevistaEntrega;
    private LocalDate dataConsulta;
}
