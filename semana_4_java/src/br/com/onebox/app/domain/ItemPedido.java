package br.com.onebox.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedidos")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtos_id", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedidos_id", nullable = false)
    private Pedido pedido;

    @Column(name = "precoUnitario_itenspedido", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "quantidade_itenspedido", nullable = false)
    private int quantidade;

    @Column(name = "desconto", precision = 10, scale = 2, nullable = false)
    private BigDecimal desconto;

    public ItemPedido(Produto produto, int quantidade) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public void setTipoDesconto(TipoDescontoProdutoEnum tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_desconto", nullable = false)
    private TipoDescontoProdutoEnum tipoDesconto;

    public ItemPedido(Produto produto, Pedido pedido, BigDecimal precoUnitario, int quantidade, BigDecimal desconto, TipoDescontoProdutoEnum tipoDesconto) {
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoDesconto = tipoDesconto;
    }

    public ItemPedido() {

    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        BigDecimal total = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
        if (desconto != null && tipoDesconto != null) {
            if (tipoDesconto.equals(TipoDescontoProdutoEnum.QUANTIDADE)) {
                total = total.subtract(desconto.multiply(BigDecimal.valueOf(quantidade)));

            } else if (tipoDesconto.equals(TipoDescontoProdutoEnum.PROMOCAO)) {
                total = total.subtract(desconto);
            }
        }
        return total;
    }

}
