package com.example.resttempcep.v1.service;

import com.example.resttempcep.v1.entity.CepEntity;

public class PriceNDeadline extends CepEntity {//TODO -> Regras de negocios

    Double valorPeso = 1.00;

    String cepOrigem = String.valueOf(getCepOrigem());
    String cepDestino = String.valueOf(getCeDestino());

     Boolean cepsMesmoUf = Boolean.valueOf(String.valueOf(cepDestino.substring(0, 1).equals(cepOrigem.substring(0, 1))));

    if (cepsMesmoUf) {
        setDataPrevistaEntrega("1");
        setVlTotalFrete((getPesoEncomenda()*valorPeso)/2);

    }else if(cepsMesmoUf && getCepOrigem().getDdd().equals(getCeDestino().getDdd())) {
        setDataPrevistaEntrega("3");
        double SetECinco = 75/100;
        setVlTotalFrete(getPesoEncomenda()*valorPeso-(SetECinco*valorPeso));

    }else if(!cepsMesmoUf) {
        setDataPrevistaEntrega("10");
       setVlTotalFrete(getPesoEncomenda()*valorPeso);
    }

//    public void cauloFreteCinquenta() {
//        setDataPrevistaEntrega("1");
//        setVlTotalFrete((getPesoEncomenda()*valorPeso)/2);
//    }
//
//    public void cauloFreteStentaECinco() {
//        setDataPrevistaEntrega("3");
//        double SetECinco = 75/100;
//        setVlTotalFrete(getPesoEncomenda()*valorPeso-(SetECinco*valorPeso));
//    }
//
//    public void semDesconto(){
//        setDataPrevistaEntrega("10");
//        setVlTotalFrete(getPesoEncomenda()*valorPeso);
//    }


}

