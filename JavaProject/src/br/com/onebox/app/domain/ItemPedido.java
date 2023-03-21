package br.com.onebox.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")

public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Produto produto;
    @ManyToOne
    private Pedido pedido;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    @Column(name = "quantidade")
    private int Quantidade;
    @Column(name = "desconto")
    private BigDecimal Desconto;
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
        return Quantidade;
    }

    public BigDecimal getDesconto() {
        return Desconto;
    }

    public TipoDescontoProdutoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public BigDecimal getTotal() {
        return this.precoUnitario.multiply(new BigDecimal(this.Quantidade)).subtract(this.Desconto);
    }


    public ItemPedido(Produto produto, Pedido pedido, BigDecimal precoUnitario, int quantidade, BigDecimal desconto, TipoDescontoProdutoEnum tipoDesconto) {
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = precoUnitario;
        this.Quantidade = quantidade;
        this.Desconto = desconto;
        this.tipoDesconto = tipoDesconto;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ", pedido=" + pedido +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + Quantidade +
                ", desconto=" + Desconto +
                ", tipoDesconto=" + tipoDesconto +
                '}';
    }


}
