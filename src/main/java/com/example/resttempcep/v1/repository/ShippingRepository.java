package com.example.resttempcep.v1.repository;

import com.example.resttempcep.v1.repository.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends MongoRepository<OrderEntity, String> {
}
