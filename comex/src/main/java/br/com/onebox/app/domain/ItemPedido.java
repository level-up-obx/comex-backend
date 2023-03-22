package br.com.onebox.app.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Column(name = "preco_unitario", precision = 15, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @Column(length = 7, nullable = false)
    private int quantidade;

    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal desconto;

    @Enumerated(EnumType.STRING)
    private TipoDescontoProdutoEnum tipoDesconto;

    public ItemPedido() {
    }

    public ItemPedido(int quantidade, Produto produto, Pedido pedido, BigDecimal desconto, TipoDescontoProdutoEnum tipoDesconto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = produto.getPrecoUnitario();
        this.pedido = pedido;
        this.desconto = desconto;
        this.tipoDesconto = tipoDesconto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setTipoDesconto(TipoDescontoProdutoEnum tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public TipoDescontoProdutoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public BigDecimal getTotal(){
        return this.precoUnitario.multiply(new BigDecimal(quantidade)).multiply(desconto);
    }
}
