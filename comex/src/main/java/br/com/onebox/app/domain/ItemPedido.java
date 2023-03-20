package br.com.onebox.app.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Column(name = "preco_unitario", length = 7, nullable = false)
    private BigDecimal precoUnitario;

    @Column(length = 7, nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @Column(length = 3, nullable = false)
    private BigDecimal desconto;

    @Enumerated(EnumType.STRING)
    private TipoDescontoProdutoEnum tipoDesconto;

    public BigDecimal getTotal(){
        return this.precoUnitario.multiply(new BigDecimal(quantidade)).multiply(desconto);
    }
}
