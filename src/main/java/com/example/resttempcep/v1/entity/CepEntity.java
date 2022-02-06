package com.example.resttempcep.v1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "transporte")
public class CepEntity {

      @Id
      private String id;
      private String nome;
//    @JsonProperty("cep")
      private String cep;
      private Double vlTotalFrete;
      private Double pesoEncomenda;
      private String dataPrevistaEntrega;
      private LocalDate dataConsulta;
      private String cepOrigem;
      private String ceDestino;
      private String logradouro;
      private String bairro;
      private String complemento;
      private String uf;
      private String ddd;
      private String localidade;
}
