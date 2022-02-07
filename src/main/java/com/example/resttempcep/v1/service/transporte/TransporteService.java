package com.example.resttempcep.v1.service.transporte;

import com.example.resttempcep.v1.entity.Cep;
import com.example.resttempcep.v1.entity.Transporte;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.TransporteRepository;
import com.example.resttempcep.v1.config.ConsumerApi;
import com.example.resttempcep.v1.service.PriceNDeadline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

//TODO -> Fazer um parametro do objeto chamar a API cep, pelo cep digitado
@AllArgsConstructor
@Service
public class TransporteService {

    private final TransporteRepository repository;
    private final ConsumerApi consumerApi;
//    private PriceNDeadline priceNDeadline;


    public Transporte save(Transporte transporte) {
        return repository.save(transporte);
    }

    public Transporte findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
    }

    public Transporte update(Transporte transporte, String id) {
        Transporte transporte1 = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        transporte.setId(transporte1.getId());
        return repository.save(transporte);
    }

    public List<Transporte> findAll() {
        return repository.findAll();
    }

    public void delete(List<String> id) {
        if(!CollectionUtils.isEmpty(id)) {
            var del = repository.findAll();
            repository.delete((Transporte) del);
        }
        else{
            repository.delete((Transporte) repository.findAll());
        }
    }

    public Cep getCep(String cep){
        return consumerApi.findCep(cep);
    }

}


