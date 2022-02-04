package com.example.resttempcep.v1.service;

import com.example.resttempcep.v1.entity.Cep;
import com.example.resttempcep.v1.entity.Entity;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.Repository;
import com.example.resttempcep.v1.restTemplate.ConsumerApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@AllArgsConstructor
@Service
public class CepService {

    private final Repository repository;
    private final ConsumerApi consumerApi;

    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    public Entity findById( String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
    }

    public Entity update(Entity entity,String id) {
        Entity entity1 = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        entity.setId(entity1.getId());
        return repository.save(entity);
    }

    public List<Entity> findAll() {
        return repository.findAll();
    }

    public void delete(List<String> id) {
        if(!CollectionUtils.isEmpty(id)) {
            var del = repository.findAll();
            repository.delete((Entity) del);
        }
        else{
            repository.delete((Entity) repository.findAll());
        }
    }
    public Cep findCep(String cep){
        return consumerApi.findCep(cep);
    }
}


