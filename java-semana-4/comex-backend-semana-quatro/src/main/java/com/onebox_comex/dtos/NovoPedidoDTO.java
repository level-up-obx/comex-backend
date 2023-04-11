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
    private LocalDate dataDoPedido;
    private List<ItemPedidoDTO> itens;
    private ClienteDTO cliente;
    private BigDecimal preco;
    private BigDecimal desconto;
    private TipoDescontoPedidoEnum tipoDescontoPedido;
    private int quantidade;

}
