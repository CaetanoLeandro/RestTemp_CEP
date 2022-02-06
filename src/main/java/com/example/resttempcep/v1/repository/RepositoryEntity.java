package com.example.resttempcep.v1.repository;

import com.example.resttempcep.v1.entity.CepEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryEntity extends MongoRepository<CepEntity, String> {
}
