package com.example.resttempcep.v1.service.destinatario;

import com.example.resttempcep.v1.entity.Destinatario;
import com.example.resttempcep.v1.exceptions.notfound.NotFoundException;
import com.example.resttempcep.v1.repository.DestinatarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;

@AllArgsConstructor
@Service
public class DestinatarioService {

    private final DestinatarioRepository repository;

    public Destinatario save(Destinatario destinatario) {
        return repository.save(destinatario);
    }

    public Destinatario update(Destinatario destinatario, String id) {
        Destinatario destinatarioId = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        destinatario.setId(destinatarioId.getId());
        return repository.save(destinatario);
    }

    public Destinatario findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
    }

    public List<Destinatario> findAll() {
        return repository.findAll();
    }

    public void delete(List<String> id) {
        if(!CollectionUtils.isEmpty(id)) {
            var del = repository.findAll();
            repository.delete((Destinatario) del);
        }
        else{
            repository.delete((Destinatario) repository.findAll());
        }
    }

}
