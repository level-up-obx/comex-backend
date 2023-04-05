package com.onebox_comex.dtos;

import com.onebox_comex.entity.Cliente;
import com.onebox_comex.entity.ItemPedido;
import com.onebox_comex.entity.Pedido;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.enums.TipoDescontoItemPedidoEnum;
import com.onebox_comex.enums.TipoDescontoPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private LocalDate data;
    private List<ItemPedidoDTO> itensPedidos = new ArrayList<>();
    //    private Long produtoId;
    private BigDecimal desconto;
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = new ClienteDTO(pedido.getCliente());
        this.data = LocalDate.now();
        this.desconto = pedido.getDesconto();
        this.tipoDescontoPedidoEnum = pedido.getTipoDescontoPedidoEnum();
        this.itensPedidos = new ItemPedidoDTO().converter(pedido.getItensPedidos());
    }
}
