package com.example.resttempcep.v1.repository;

import com.example.resttempcep.v1.entity.TransporteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends MongoRepository<TransporteEntity, String> {
}
