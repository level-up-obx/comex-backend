package com.onebox_comex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onebox_comex.enums.TipoDescontoItemPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;
    @Column(precision = 10, scale = 2)
    private BigDecimal precoUnitario;
    @Column
    private int quantidade;
    @Column(precision = 10, scale = 2)
    private BigDecimal desconto;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoDescontoItemPedidoEnum tipoDescontoItemPedido;

    public ItemPedido(Produto produto, Pedido pedido, int quantidade, BigDecimal desconto,
                        TipoDescontoItemPedidoEnum tipoDescontoItemPedido) {
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = produto.getPrecoUnitario();
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoDescontoItemPedido = tipoDescontoItemPedido;
    }

    public ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return getPrecoUnitario().multiply(new BigDecimal(getQuantidade())).subtract(getDesconto());
    }

    }

