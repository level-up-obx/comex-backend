package br.com.onebox.app.dtos;

import br.com.onebox.app.entity.ItemPedido;
import br.com.onebox.app.entity.Pedido;
import br.com.onebox.app.entity.Produto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoDTO {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private Long idProduto;
    private Integer quantidade;
    private Produto produto;

    public static List<ItemPedidoDTO> converter(List<ItemPedido> itens) {
        return itens.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
    }
    public ItemPedidoDTO(ItemPedido itemPedido) {
        this.idProduto = itemPedido.getProduto().getId();
        this.quantidade = itemPedido.getQuantidade();
    }



    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getProdutoId() {
        return idProduto;
    }
}