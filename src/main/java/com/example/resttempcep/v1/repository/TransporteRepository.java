package com.example.resttempcep.v1.repository;

import com.example.resttempcep.v1.entity.Transporte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends MongoRepository<Transporte, String> {
}
