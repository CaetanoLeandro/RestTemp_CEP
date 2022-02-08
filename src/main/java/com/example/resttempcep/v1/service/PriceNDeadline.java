package com.example.resttempcep.v1.service;

import com.example.resttempcep.v1.entity.CepIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
@Component
public class PriceNDeadline extends CepIntegration {

    private RestTemplate restTemplate;

    private final Double valorPeso = 1.00D;

    public void validaCep(String cepOrigem, String cepDestino ) {

        CepIntegration cep1 = restTemplate.getForObject("https://viacep.com.br/ws/" + cepOrigem + "/json/", CepIntegration.class);
        CepIntegration cep2 = restTemplate.getForObject("https://viacep.com.br/ws/" + cepDestino + "/json/", CepIntegration.class);


        Double valorTotalFrete;
         boolean isSameUf = Boolean.parseBoolean(String.valueOf(cepDestino.substring(0, 1)
                 .equals(cepOrigem.substring(0, 1))));

         // getDdd() is CepIntegration
        boolean isSameDdd = cep1.getDdd().equals(cep2.getDdd());

         if (isSameUf) {
             getDataPrevistaEntrega(1);
//             valorTotalFrete()
        } else if (isSameUf && isSameDdd) {
//             getDataPrevistaEntrega(3);
//             (validaValorFrete() * 0.25D) * valorPeso);
         } else {
             getDataPrevistaEntrega(10);
//             valorTotalFrete(getPesoEncomenda() * valorPeso);
         }

     }

//    public void validaValorFrete(Double encomenda) {
//         encomenda * 0.25 * valorPeso;
//    }

    private Date getDataPrevistaEntrega(final Integer dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, dias);
        return calendar.getTime();
    }

}
