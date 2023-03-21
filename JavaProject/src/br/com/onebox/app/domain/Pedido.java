package br.com.onebox.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static int id;

    private String produto;

    @ManyToOne
    private String cliente;
    private double preco;
    private int quantidade;
    private LocalDate data ;
    private List<ItemPedido> itens;

    private BigDecimal Desconto;
    private TipoDeDescontoPedidoEnum TipoDeDesconto;


    public int getId() {
        return id;
    }


    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

//    public LocalDate getData() {
//        return data;
//    }

    @Override
    public String toString() {
        return " ---------- Pedido------------- " + "\n" + ++id + " - " +
                "produto = " + produto +
                " - cliente = " + cliente +
                " - preco = " + preco +
                " - data = " + data +
                " - quantidade = " + quantidade +
                '\'';
    }


    public Pedido(String produto, String cliente, double preco, int quantidade, LocalDate data) {

        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;


    }

    public static int pedidoid() {
        id = ++id;
        return ++id;

    }

    public boolean isMaisBaratoQue(Pedido outroPedido) {


        return false;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {

        return false;
    }

    public BigDecimal getValorTotal() {
        BigDecimal valortotal = BigDecimal.valueOf(quantidade * preco);
        return valortotal;
    }
}

