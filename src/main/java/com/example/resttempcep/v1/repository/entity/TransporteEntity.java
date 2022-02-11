package com.example.resttempcep.v1.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "transportes")
public class TransporteEntity {
      @Id
      private String id;
      private Double valorTotalFrete;
      private Date dataPrevistaEntrega;
      private LocalDate dataConsulta;
     // private AddressIntegration cep;
}
