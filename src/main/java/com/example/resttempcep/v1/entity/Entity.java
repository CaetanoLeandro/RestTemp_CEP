package com.example.resttempcep.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Data
@Document(collection = "transporte")
public class Entity {
    @Id
    private String id;
    @NonNull
    private String nomeDestinatario;

}
