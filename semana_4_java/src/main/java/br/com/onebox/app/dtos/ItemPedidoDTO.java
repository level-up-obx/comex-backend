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

    public ItemPedidoDTO(Pedido pedido, Long idProduto, Integer quantidade, Produto produto) {
        this.pedido = pedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public ItemPedidoDTO() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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
}

