package br.com.onebox.app.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "produto_id", nullable = false)
    @Column(nullable = false)
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
    @Column(nullable = false)
    private BigDecimal precoUnitario = BigDecimal.ZERO;
    @Max(1000)
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private BigDecimal desconto;
    @Column(nullable = false)
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

