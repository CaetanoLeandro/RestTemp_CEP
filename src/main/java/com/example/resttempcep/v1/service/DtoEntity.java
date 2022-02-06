package com.example.resttempcep.v1.service;


import com.example.resttempcep.v1.entity.ApiExtEntity;
import com.example.resttempcep.v1.entity.CepEntity;

public class DtoEntity {

        public static CepEntity DtoEntity (ApiExtEntity apiExtEntity){
            return CepEntity.builder()
                    .cep(apiExtEntity.getCep())
                    .logradouro(apiExtEntity.getLogradouro())
                    .bairro(apiExtEntity.getBairro())
                    .complemento(apiExtEntity.getComplemento())
                    .uf(apiExtEntity.getUf())
                    .ddd(apiExtEntity.getDdd())
                    .localidade(apiExtEntity.getLocalidade())
                    .build();
        }

}
