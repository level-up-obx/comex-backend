package com.onebox_comex.dtos;

import com.onebox_comex.entity.ItemPedido;
import com.onebox_comex.entity.Pedido;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.enums.TipoDescontoItemPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    private Long produtoId;
    private ProdutoDTO produto;
    private Long clienteId;
    private int quantidade;
    private Long id;
    private BigDecimal precoUnitario;
    private BigDecimal desconto;
    private TipoDescontoItemPedidoEnum tipoDescontoItemPedido;
    private Pedido pedido;

    public List<ItemPedidoDTO> converter(List<ItemPedido> itens){
        List<ItemPedidoDTO> lista = new ArrayList<>();
        itens.forEach(item -> lista.add(new ItemPedidoDTO(item)));
        return lista;
    }

    public void converter(ItemPedido itemPedido){
        this.id = itemPedido.getId();
        this.produto = itemPedido.getProduto().converter();
        this.precoUnitario = itemPedido.getPrecoUnitario();
        this.quantidade = itemPedido.getQuantidade();
        this.desconto = itemPedido.getDesconto();
        this.tipoDescontoItemPedido = itemPedido.getTipoDescontoItemPedido();
    }

    public ItemPedidoDTO(ItemPedido itemPedido){
        this.id = itemPedido.getId();
        this.produto = itemPedido.getProduto().converter();
        this.precoUnitario = itemPedido.getPrecoUnitario();
        this.quantidade = itemPedido.getQuantidade();
        this.desconto = itemPedido.getDesconto();
        this.tipoDescontoItemPedido = itemPedido.getTipoDescontoItemPedido();
    }

}
