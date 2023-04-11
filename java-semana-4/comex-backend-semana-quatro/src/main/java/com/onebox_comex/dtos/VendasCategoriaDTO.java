package com.onebox_comex.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VendasCategoriaDTO {
    private String nomeCategoria;
    private Long quantidadeProdutosVendidos;
    private BigDecimal montanteVendido;

}

