package com.example.resttempcep.v1.service;

import com.example.resttempcep.v1.entity.ApiExtEntity;
import com.example.resttempcep.v1.entity.CepEntity;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.RepositoryEntity;
import com.example.resttempcep.v1.restTemplate.ConsumerApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

//TODO -> Fazer um parametro do objeto chamar a API cep, pelo cep digitado
@AllArgsConstructor
@Service
public class CepService {

    private final RepositoryEntity repository;
    private final ConsumerApi consumerApi;


    public CepEntity save(CepEntity cepEntity) {
        return repository.save(cepEntity);
    }

    public CepEntity findById( String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
    }

    public CepEntity update(CepEntity cepEntity,String id) {
        CepEntity cepEntity1 = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        cepEntity.setId(cepEntity1.getId());
        return repository.save(cepEntity);
    }

    public List<CepEntity> findAll() {
        return repository.findAll();
    }

    public void delete(List<String> id) {
        if(!CollectionUtils.isEmpty(id)) {
            var del = repository.findAll();
            repository.delete((CepEntity) del);
        }
        else{
            repository.delete((CepEntity) repository.findAll());
        }
    }

    public ApiExtEntity getCep(String cep){
        return consumerApi.findCep(cep);
    }

}


