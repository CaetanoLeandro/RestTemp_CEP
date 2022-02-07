package com.example.resttempcep.v1.entity;

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
public class Transporte {
      @Id
      private String id;
      private Double valorTotalFrete;
      private Date dataPrevistaEntrega;
      private LocalDate dataConsulta;

      private String logradouro;
      private String bairro;
      private String complemento;
      private String uf;
      private String ddd;
      private String localidade;
}
