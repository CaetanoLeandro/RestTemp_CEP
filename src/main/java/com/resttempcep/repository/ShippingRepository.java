package com.resttempcep.repository;

import com.resttempcep.repository.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends MongoRepository<OrderEntity, String> {
}
