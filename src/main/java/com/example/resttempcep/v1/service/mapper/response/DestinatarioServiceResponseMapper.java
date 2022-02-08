package com.example.resttempcep.v1.service.mapper.response;

import com.example.resttempcep.v1.entity.CepEntity;
import com.example.resttempcep.v1.entity.CepIntegration;
import com.example.resttempcep.v1.entity.DestinatarioEntity;
import com.example.resttempcep.v1.service.model.response.DestinatarioServiceResponse;

import java.util.Optional;

public class DestinatarioServiceResponseMapper {

    public static DestinatarioServiceResponse
    toDestinatarioServiceResponse(DestinatarioEntity destinatarioEntity, CepIntegration cep) {
        return Optional.ofNullable(destinatarioEntity)
                .map(destinatarioEntity1 -> DestinatarioServiceResponse.builder()
                .id(destinatarioEntity.getId())
                .nomeDestinatario(destinatarioEntity.getNomeDestinatario())
                .pesoEncomenda(destinatarioEntity.getPesoEncomenda())
                .cepOrigem(toDestinatarioEntity(cep))
                .cepDestino(toDestinatarioEntity(cep))
                .build()).orElse(null);
    }

    public static CepEntity toDestinatarioEntity (CepIntegration cepIntegration){
        return Optional.ofNullable(cepIntegration).map(cep -> CepEntity.builder()
                .cep(cepIntegration.getCep())
                .localidade(cepIntegration.getLocalidade())
                .bairro(cepIntegration.getBairro())
                .complemento(cepIntegration.getComplemento())
                .ddd(cepIntegration.getDdd())
                .uf(cepIntegration.getUf())
                .build()).orElse(null);

    }

}
