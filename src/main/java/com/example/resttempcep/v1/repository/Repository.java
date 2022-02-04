package com.example.resttempcep.v1.repository;

import com.example.resttempcep.v1.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Entity, String> {
}
