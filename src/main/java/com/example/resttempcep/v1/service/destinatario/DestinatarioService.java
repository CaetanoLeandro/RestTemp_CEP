package com.example.resttempcep.v1.service.destinatario;

import com.example.resttempcep.v1.entity.DestinatarioEntity;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.DestinatarioRepository;
import com.example.resttempcep.v1.service.PriceNDeadline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class DestinatarioService {

    private final DestinatarioRepository repository;
    private final PriceNDeadline priceNDeadline;

    public DestinatarioEntity save(DestinatarioEntity destinatarioEntity) {
        priceNDeadline.validaCep(destinatarioEntity.getCepOrigem(), destinatarioEntity.getCepDestino());
        return repository.save(destinatarioEntity);
    }

    public DestinatarioEntity update(DestinatarioEntity destinatarioEntity, String id) {
        destinatarioEntity.setId(id);
        return repository.save(destinatarioEntity);
    }

    public DestinatarioEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
    }

    public List<DestinatarioEntity> findAll() {
        return repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
