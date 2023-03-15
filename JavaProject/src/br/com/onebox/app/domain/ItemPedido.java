package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ItemPedido {

    private Produto produto;
    private Pedido pedido;
    private BigDecimal precoUnitario;
    private int quantidade;
    private BigDecimal desconto;
    private TipoDescontoProdutoEnum tipoDesconto;

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public TipoDescontoProdutoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public BigDecimal getTotal() {
        return this.precoUnitario.multiply(new BigDecimal(this.quantidade)).subtract(this.desconto);
    }


    public ItemPedido(Produto produto, Pedido pedido, BigDecimal precoUnitario, int quantidade, BigDecimal desconto, TipoDescontoProdutoEnum tipoDesconto) {
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoDesconto = tipoDesconto;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ", pedido=" + pedido +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                ", desconto=" + desconto +
                ", tipoDesconto=" + tipoDesconto +
                '}';
    }


}
