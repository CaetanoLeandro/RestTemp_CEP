package com.example.resttempcep.v1.repository;

import com.example.resttempcep.v1.entity.Destinatario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DestinatarioRepository extends MongoRepository<Destinatario, String> {
}