package com.example.resttempcep.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "destinatarios")
public class DestinatarioEntity {
    @Id
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    private String cepOrigem;
    private String cepDestino;

}
