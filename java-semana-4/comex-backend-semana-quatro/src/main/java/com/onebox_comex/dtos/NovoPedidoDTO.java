package com.onebox_comex.dtos;

import com.onebox_comex.entity.Cliente;
import com.onebox_comex.enums.TipoDescontoPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NovoPedidoDTO {
    private Long id;
    private Long clienteId;
    private List<ItemPedidoDTO> itensPedidos;
    private ClienteDTO cliente;
    private LocalDate data;
    private Long produtoId;
    private BigDecimal desconto;
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;
    private LocalDate dataDoPedido;
    private int quantidadeDePedidos;
    private BigDecimal precoPedido;

}
