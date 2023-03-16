package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ItemPedido {
    private Produto produto;
    private Pedido pedido;
    private BigDecimal precoUnitario = BigDecimal.ZERO;
    private int quantidade;
    private BigDecimal desconto;
    private TipoDescontoItemPedidoEnum tipoDescontoItemPedido;

    public ItemPedido(Produto produto, Pedido pedido, BigDecimal precoUnitario, int quantidade, BigDecimal desconto, TipoDescontoItemPedidoEnum tipoDesconto) {
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoDescontoItemPedido = tipoDesconto;
    }

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

    public TipoDescontoItemPedidoEnum getTipoDescontoItemPedido() {
        return tipoDescontoItemPedido;
    }

    public BigDecimal getTotal() {
        BigDecimal total = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
                if (tipoDescontoItemPedido == TipoDescontoItemPedidoEnum.QUANTIDADE) {
                    total = total.subtract(desconto.multiply(BigDecimal.valueOf(quantidade)));
                }
                if (tipoDescontoItemPedido == TipoDescontoItemPedidoEnum.PROMOCAO) {
                    total = total.subtract(desconto);
                }
        return total;
    }
    }

