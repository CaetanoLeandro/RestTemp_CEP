package com.example.resttempcep.v1.repository.entity;

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
@Document(collection = "encomenda")
public class OrderEntity {
    @Id
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    private AddressEntity addressOrigin;
    private AddressEntity addressDestination;
}
