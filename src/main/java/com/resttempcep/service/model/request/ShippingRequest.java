package com.resttempcep.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShippingRequest {
    private String id;
    private String nomeDestinatario;
    private Double pesoEncomenda;
    //@Pattern(RegexpURLValidator == )
    private String cepOrigem;
    //@Pattern()
    private String cepDestino;
}
