package com.onebox_comex.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ItemPedidoDTO {
    @NotBlank
    private Long produtoId;
    @NotBlank
    private int quantidade;
}
