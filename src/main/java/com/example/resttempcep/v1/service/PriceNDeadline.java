package com.example.resttempcep.v1.service;

import com.example.resttempcep.v1.entity.Transporte;

import java.time.LocalDate;
import java.util.Date;

public class PriceNDeadline extends Transporte { //TODO -> Regras de negocios

    private Double valorTotalFrete;
    private Date dataPrevistaEntrega;
    private LocalDate dataConsulta;


    Double valorPeso = 1.00D;
    Date dataPrevisaoEntrega;

    String cepOrigem =  String.valueOf(getCepOrigem());
    String cepDestino = String.valueOf(getCeDestino());

     Boolean cepsMesmoUf = Boolean.valueOf(String.valueOf(cepDestino.substring(0, 1)
             .equals(cepOrigem.substring(0, 1))));

     Boolean mesmoDDD = getCepOrigem()
             .getDdd()
             .equals(getCeDestino().getDdd());


     public Boolean validaCep(Boolean cepsMesmoUf, Boolean mesmoDDD ) {
         if (cepsMesmoUf) {
             dataPrevisaoEntrega = getDataPrevistaEntrega(1);
             valorTotalFrete((getPesoEncomenda() * 0.50D) * valorPeso);

         } else if (cepsMesmoUf && mesmoDDD) {
             dataPrevisaoEntrega = getDataPrevistaEntrega(3);
             valorTotalFrete((getPesoEncomenda() * 0.25D) * valorPeso);

         } else if (!cepsMesmoUf) {
             dataPrevisaoEntrega = getDataPrevistaEntrega(10);
             valorTotalFrete(getPesoEncomenda() * valorPeso);
         }
     }

    private Date getDataPrevistaEntrega(final Integer dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, dias);
        return calendar.getTime();
    }

}
