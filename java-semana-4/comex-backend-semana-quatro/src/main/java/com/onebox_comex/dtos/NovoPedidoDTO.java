package com.onebox_comex.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class NovoPedidoDTO {
    @NotBlank
    private Long clienteId;
    @NotBlank
    private List<ItemPedidoDTO> itensPedidos;
}
