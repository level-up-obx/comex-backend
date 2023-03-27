package br.com.onebox.app.entity;

import br.com.onebox.app.enums.TipoDescontoItemPedidoEnum;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

@Entity
@Table(name = "itemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    @Column(nullable = false)
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;
    @Max(1000)
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
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

