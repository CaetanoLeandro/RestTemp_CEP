package com.example.resttempcep.v1.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "transporte")
public class DadosTransporteEntity {

    private String nomeDestinatario;
    private Double vlTotalFrete;
    private Double pesoEncomenda;
    private String dataPrevistaEntrega;
    private LocalDate dataConsulta;
    private String ddd;
    private CepEntity cepOrigem;
    private CepEntity ceDestino;

}
